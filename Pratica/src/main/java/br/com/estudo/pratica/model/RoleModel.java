package br.com.estudo.pratica.model;

import br.com.estudo.pratica.model.enums.RoleName;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ROLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoleModel implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
