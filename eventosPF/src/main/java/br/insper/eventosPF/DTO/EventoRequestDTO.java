package br.insper.eventosPF.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventoRequestDTO {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private LocalDate data;
}
