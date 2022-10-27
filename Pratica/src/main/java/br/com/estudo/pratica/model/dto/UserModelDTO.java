package br.com.estudo.pratica.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.context.annotation.Bean;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModelDTO {

    @JsonIgnore
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;

}
