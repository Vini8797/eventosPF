package br.insper.eventosPF.service;

import br.insper.eventosPF.dto.UserRequestDTO;
import br.insper.eventosPF.dto.UserResponseDTO;
import br.insper.eventosPF.entity.User;
import br.insper.eventosPF.Papel;
import br.insper.eventosPF.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private void validarAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (user.getPapel() != Papel.ADMIN) {
            throw new RuntimeException("Acesso negado");
        }
    }

    public UserResponseDTO criar(UserRequestDTO dto, Long userId) {
        validarAdmin(userId);
        User u = User.toModel(dto);
        userRepository.save(u);
        return UserResponseDTO.toDTO(u);
    }

    public List<UserResponseDTO> listar() {
        return userRepository.findAll().stream()
                .filter(u -> !u.isDeleted())
                .map(UserResponseDTO::toDTO)
                .toList();
    }

    public void deletar(Long id, Long userId) {
        validarAdmin(userId);
        User u = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        u.setDeleted(true);
        userRepository.save(u);
    }
}
