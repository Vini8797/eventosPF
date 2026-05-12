package br.insper.eventosPF.Service;

import br.insper.eventosPF.DTO.EventoRequestDTO;
import br.insper.eventosPF.DTO.EventoResponseDTO;
import br.insper.eventosPF.Model.Evento;
import br.insper.eventosPF.Model.User;
import br.insper.eventosPF.Papel;
import br.insper.eventosPF.Repository.EventoRepository;
import br.insper.eventosPF.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UserRepository userRepository;

    private void validarAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (user.getPapel() != Papel.ADMIN) {
            throw new RuntimeException("Acesso negado");
        }
    }

    public EventoResponseDTO criar(EventoRequestDTO dto, Long userId) {
        validarAdmin(userId);
        Evento e = Evento.toModel(dto);
        eventoRepository.save(e);
        return EventoResponseDTO.toDTO(e);
    }

    public List<EventoResponseDTO> listar() {
        return eventoRepository.findAll().stream()
                .filter(e -> !e.isDeleted())
                .map(EventoResponseDTO::toDTO)
                .toList();
    }

    public void deletar(Long id, Long userId) {
        validarAdmin(userId);
        Evento e = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        e.setDeleted(true);
        eventoRepository.save(e);
    }

    public void associarUsuario(Long eventoId, Long userIdParticipante, Long userId) {
        validarAdmin(userId);
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        User user = userRepository.findById(userIdParticipante)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (evento.getUsuarios().contains(user)) {
            throw new RuntimeException("Usuário já inscrito neste evento");
        }
        evento.getUsuarios().add(user);
        user.getEventos().add(evento);
        eventoRepository.save(evento);
        userRepository.save(user);
    }
}
