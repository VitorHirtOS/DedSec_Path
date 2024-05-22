package dedsec.projeto_dedsec.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="dedsec")
@Table(name="dedsec")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String password;
}
