package br.insper.eventosPF.Controller;

import br.insper.eventosPF.DTO.UserRequestDTO;
import br.insper.eventosPF.DTO.UserResponseDTO;
import br.insper.eventosPF.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserResponseDTO criar(@Valid @RequestBody UserRequestDTO dto, @RequestHeader("X-USER-ID") Long userId) {
        return service.criar(dto, userId);
    }

    @GetMapping
    public List<UserResponseDTO> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id, @RequestHeader("X-USER-ID") Long userId) {
        service.deletar(id, userId);
    }
}
