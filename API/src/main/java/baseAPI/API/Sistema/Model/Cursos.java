package baseAPI.API.Sistema.Model;

import baseAPI.API.Sistema.Enum.Instituicao;
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
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 150)
    private String local;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(length = 4)
    private Long ano;
    private String certificado;
    @Lob
    private Blob imagem;

}
