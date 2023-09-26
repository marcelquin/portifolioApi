package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Perfil;
import baseAPI.API.Sistema.Repository.PerfilRepository;
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
public class PerfilService {

    @Autowired
    PerfilRepository repository;


    public List<Perfil> listar(){
        try {
            repository.findAll();
        }catch (Exception e) {
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
         return null;
    }

    public Perfil buscarPorId(Long id) {
    try {
        repository.findById(id);
    }catch (Exception e){
        new RuntimeException("ops, algo deu errado");
        e.getMessage();
    }
    return null;
    }

    public ResponseEntity<byte[]> verImagemPorId(long id) throws IOException, SQLException {
        Perfil entidade = repository.findById(id).get();
        byte[] imageBytes = null;
        imageBytes = entidade.getImgPerfil().getBytes(1, (int) entidade.getImgPerfil().length());
        return ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    public Perfil salvar(Perfil perfil, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                perfil.setImgPerfil(blob);
            }
            repository.save(perfil);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }


    public Perfil editar(Long id, Perfil perfil, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(repository.existsById(id))
            {
                if(!file.isEmpty()){
                    byte[] bytes = file.getBytes();
                    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                    perfil.setImgPerfil(blob);
                }
                repository.save(perfil);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Perfil deletarCurso(Long id)
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
