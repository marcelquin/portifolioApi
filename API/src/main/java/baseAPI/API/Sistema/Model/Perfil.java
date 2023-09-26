package baseAPI.API.Sistema.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @Column(length = 3)
    private Long idade;
    @Column(length = 2)
    private Long prefone;
    @Column(length = 9)
    private Long telefone;
    private String email;
    private String linkFacebook;
    private String linkInstagram;
    private String linkLinkedin;
    private String linkGithub;
    @Lob
    private Blob imgPerfil;
}
