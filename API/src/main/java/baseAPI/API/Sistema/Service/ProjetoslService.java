package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Projetos;
import baseAPI.API.Sistema.Repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoslService {

    @Autowired
    private final ProjetoRepository repository;


    public List<Projetos> listar(){
        try {
            repository.findAll();
        }catch (Exception e){
        new RuntimeException("ops, algo deu errado");
        e.getMessage();
    }
        return null;
    }

    public Projetos buscarPorId(Long id)
    {
        try {
            repository.findById(id);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Projetos salvar(Projetos projetos, MultipartFile file)
    {
        try {
            if (projetos != null)
            {
                if(file != null){
                    projetos.setImagem(file.getBytes());
                }
                repository.save(projetos);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Projetos editar(Long id, Projetos projetos, MultipartFile file)
    {
        try {
            if(repository.existsById(id))
            {
                if (projetos != null)
                {
                    if(file != null){
                        projetos.setImagem(file.getBytes());
                    }
                    repository.save(projetos);
                }
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Projetos deletar(Long id)
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
