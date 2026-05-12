package br.insper.eventosPF.controller;

import br.insper.eventosPF.dto.EventoRequestDTO;
import br.insper.eventosPF.dto.EventoResponseDTO;
import br.insper.eventosPF.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public EventoResponseDTO criar(@Valid @RequestBody EventoRequestDTO dto,
                                   @RequestHeader("X-USER-ID") Long userId) {
        return service.criar(dto, userId);
    }

    @GetMapping
    public List<EventoResponseDTO> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id, @RequestHeader("X-USER-ID") Long userId) {
        service.deletar(id, userId);
    }

    @PostMapping("/{id}/usuarios/{userIdParticipante}")
    public void associarUsuario(@PathVariable Long id, @PathVariable Long userIdParticipante,
                                @RequestHeader("X-USER-ID") Long userId) {
        service.associarUsuario(id, userIdParticipante, userId);
    }
}
