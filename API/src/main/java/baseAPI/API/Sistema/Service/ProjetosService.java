package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Projetos;
import baseAPI.API.Sistema.Repository.ProjetosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@Service
@RequiredArgsConstructor
public class ProjetosService {

    @Autowired
    ProjetosRepository repository;

    public List<Projetos> listar(){
        try {
            repository.findAll();
        }catch (Exception e) {
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
         return null;
    }

    public Projetos buscarPorId(Long id) {
    try {
        repository.findById(id);
    }catch (Exception e){
        new RuntimeException("ops, algo deu errado");
        e.getMessage();
    }
    return null;
    }

    public ResponseEntity<byte[]> verImagemPorId(long id) throws IOException, SQLException {
        Projetos entidade = repository.findById(id).get();
        byte[] imageBytes = null;
        imageBytes = entidade.getImagem().getBytes(1, (int) entidade.getImagem().length());
        return ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    public Projetos salvar(Projetos projetos, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                projetos.setImagem(blob);
            }
            repository.save(projetos);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }


    public Projetos editar(Long id, Projetos projetos, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(repository.existsById(id))
            {
                if(!file.isEmpty()){
                    byte[] bytes = file.getBytes();
                    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                    projetos.setImagem(blob);
                }
                repository.save(projetos);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Projetos deletarCurso(Long id)
    {
        try {
            if(repository.existsById(id))
            {
                repository.deleteById(id);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

}
