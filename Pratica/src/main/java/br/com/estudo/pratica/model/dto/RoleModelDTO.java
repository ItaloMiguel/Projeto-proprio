package br.com.estudo.pratica.model.dto;

import br.com.estudo.pratica.model.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModelDTO {

    @JsonIgnore
    private UUID id;
    private String roleName;
}
