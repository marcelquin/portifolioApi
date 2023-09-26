package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Cursos;
import baseAPI.API.Sistema.Repository.CursoRepository;
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
public class CursoService {

    @Autowired
    CursoRepository repository;


    /*
        retornar entidade de imagem separada
        criar metodo find by id separado de cursos e certificado(como auxiliar)
        listar:
            buscar fazer um foreach se existir id em ambos retornar dados + a imagem
         encontra 1:
            buscar se existir trazer informações e buscar no metodo auxiliar a imagem pelo id
          editar não testado
     */
    public List<Cursos> listar(){
        try {
            repository.findAll();
        }catch (Exception e) {
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
         return null;
    }

    public Cursos buscarPorId(Long id) {
    try {
        repository.findById(id);
    }catch (Exception e){
        new RuntimeException("ops, algo deu errado");
        e.getMessage();
    }
    return null;
    }

    public ResponseEntity<byte[]> verImagemPorId(long id) throws IOException, SQLException {
        Cursos entidade = repository.findById(id).get();
        byte[] imageBytes = null;
        imageBytes = entidade.getImagem().getBytes(1, (int) entidade.getImagem().length());
        return ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    public Cursos salvar(Cursos cursos, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                cursos.setImagem(blob);
                cursos.setCertificado(file.getOriginalFilename());
            }
            repository.save(cursos);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }


    public Cursos editar(Long id, Cursos cursos, MultipartFile file) throws SQLException, IOException
    {
        try {
            if(repository.existsById(id))
            {
                if(!file.isEmpty()){
                    byte[] bytes = file.getBytes();
                    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                    cursos.setImagem(blob);
                    cursos.setCertificado(file.getOriginalFilename());
                }
                repository.save(cursos);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Cursos deletarCurso(Long id)
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




    //CRUD CERTIFICCADO IMAGEM

}
