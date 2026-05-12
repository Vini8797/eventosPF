package br.insper.eventosPF.dto;

import br.insper.eventosPF.entity.User;
import br.insper.eventosPF.Papel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Papel papel;

    public static UserResponseDTO toDTO(User u) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setCpf(u.getCpf());
        dto.setPapel(u.getPapel());
        return dto;
    }
}
