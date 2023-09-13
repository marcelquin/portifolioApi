package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Cursos;
import baseAPI.API.Sistema.Model.Habilidades;
import baseAPI.API.Sistema.Repository.CursosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoslService {

    @Autowired
    private CursosRepository repository;

    public List<Cursos> listar(){
        try {
            repository.findAll();
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Cursos buscarPorId(Long id)
    {
        try {
            repository.findById(id);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Cursos salvar(Cursos cursos, MultipartFile file)
    {
        try {
            if (cursos != null)
            {
                if(file != null){
                    cursos.setCertificado(file.getBytes());
                }
                repository.save(cursos);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Cursos editar(Long id, Cursos cursos, MultipartFile file)
    {
        try {
            if(repository.existsById(id))
            {
                if (cursos != null)
                {
                    if(file != null){
                        cursos.setCertificado(file.getBytes());
                    }
                    repository.save(cursos);
                }
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Cursos deletar(Long id)
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
