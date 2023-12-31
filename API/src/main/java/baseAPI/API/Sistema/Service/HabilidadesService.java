package baseAPI.API.Sistema.Service;


import baseAPI.API.Sistema.Model.Habilidades;
import baseAPI.API.Sistema.Repository.HabilidadesRepository;
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
public class HabilidadesService {

    @Autowired
    HabilidadesRepository repository;


    public List<Habilidades> listar(){
        try {
            repository.findAll();
        }catch (Exception e) {
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
         return null;
    }

    public Habilidades buscarPorId(Long id) {
    try {
        repository.findById(id);
    }catch (Exception e){
        new RuntimeException("ops, algo deu errado");
        e.getMessage();
    }
    return null;
    }

    public ResponseEntity<byte[]> verImagemPorId(long id) throws IOException, SQLException {
        Habilidades entidade = repository.findById(id).get();
        byte[] imageBytes = null;
        imageBytes = entidade.getImagem().getBytes(1, (int) entidade.getImagem().length());
        return ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    public Habilidades salvar(Habilidades habilidades, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                habilidades.setImagem(blob);
            }
            repository.save(habilidades);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }


    public Habilidades editar(Long id, Habilidades habilidades, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(repository.existsById(id))
            {
                if(!file.isEmpty()){
                    byte[] bytes = file.getBytes();
                    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                    habilidades.setImagem(blob);
                }
                repository.save(habilidades);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Habilidades deletarCurso(Long id)
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
