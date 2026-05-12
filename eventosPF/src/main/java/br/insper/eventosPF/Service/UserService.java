package br.insper.eventosPF.Service;

import br.insper.eventosPF.DTO.UserRequestDTO;
import br.insper.eventosPF.DTO.UserResponseDTO;
import br.insper.eventosPF.Model.User;
import br.insper.eventosPF.Papel;
import br.insper.eventosPF.Repository.UserRepository;
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
