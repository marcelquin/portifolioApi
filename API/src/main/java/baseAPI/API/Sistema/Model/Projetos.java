package baseAPI.API.Sistema.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String descrisao;
    private String linkGit;
    @Lob
    private Blob imagem;
}
