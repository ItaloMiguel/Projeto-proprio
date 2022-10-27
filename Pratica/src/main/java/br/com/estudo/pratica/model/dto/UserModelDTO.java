package br.com.estudo.pratica.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModelDTO {

    @JsonIgnore
    private UUID id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;

}
