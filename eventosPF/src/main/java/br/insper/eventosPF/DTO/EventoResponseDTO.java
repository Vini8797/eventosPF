package br.insper.eventosPF.DTO;

import br.insper.eventosPF.Model.Evento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventoResponseDTO {

    private Integer id;
    private String nome;
    private LocalDate data;

    public static EventoResponseDTO toDTO(Evento e) {
        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setData(e.getData());
        return dto;
    }
}
