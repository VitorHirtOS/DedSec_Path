package dedsec.projeto_dedsec.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "dedsec")
@Table(name = "dedsec")
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;

}
