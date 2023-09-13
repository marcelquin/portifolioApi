package baseAPI.API.Sistema.Model;

import baseAPI.API.Sistema.Enum.Linguagens;
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
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated
    private Linguagens linguagens;
    @Column(name = "git_Link")
    private String gitLink;
    @Lob
    private byte[] imagem;
}

