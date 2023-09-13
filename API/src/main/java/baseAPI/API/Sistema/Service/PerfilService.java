package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Perfil;
import baseAPI.API.Sistema.Model.Projetos;
import baseAPI.API.Sistema.Repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilService {

    @Autowired
    private final PerfilRepository repository;


    public List<Perfil> listar(){
        try {
            repository.findAll();
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Perfil buscarPorId(Long id)
    {
        try {
            repository.findById(id);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Perfil Salvar(Perfil perfil, MultipartFile file)
    {
        try {
            if (perfil != null)
            {
                if(file != null){
                    perfil.setImagem(file.getBytes());
                }
                repository.save(perfil);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Perfil editar(Long id, Perfil perfil, MultipartFile file)
    {
        try {
            if(repository.existsById(id))
            {
                if (perfil != null)
                {
                    if(file != null){
                        perfil.setImagem(file.getBytes());
                    }
                    repository.save(perfil);
                }
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Perfil deletar(Long id)
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
