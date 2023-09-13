package baseAPI.API.Sistema.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long idade;
    private String email;
    private int prefone;
    private Long telefone;
    private String linkFacebook;
    private String linkinstagram;
    private String linkLinkedin;
    private String linkGit;
    @Lob
    private byte[] imagem;
}
