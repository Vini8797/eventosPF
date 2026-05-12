package br.insper.eventosPF.Model;

import br.insper.eventosPF.DTO.UserRequestDTO;
import br.insper.eventosPF.Papel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Papel papel;

    @ManyToMany
    private List<Evento> eventos = new ArrayList<>();

    private boolean deleted;

    public static User toModel(UserRequestDTO dto) {
        User u = new User();
        u.setNome(dto.getNome());
        u.setCpf(dto.getCpf());
        u.setPapel(dto.getPapel());
        return u;
    }
}
