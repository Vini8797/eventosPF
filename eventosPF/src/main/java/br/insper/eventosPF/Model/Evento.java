package br.insper.eventosPF.Model;

import br.insper.eventosPF.DTO.EventoRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToMany(mappedBy = "eventos")
    private List<User> usuarios = new ArrayList<>();

    private boolean deleted;

    public static Evento toModel(EventoRequestDTO dto) {
        Evento e = new Evento();
        e.setNome(dto.getNome());
        e.setData(dto.getData());
        return e;
    }
}
