package dedsec.projeto_dedsec.domain;

import lombok.*;
import javax.persistence.*;

@Table(name="dedsec")
@Entity(name="dedsec")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String password;
}
