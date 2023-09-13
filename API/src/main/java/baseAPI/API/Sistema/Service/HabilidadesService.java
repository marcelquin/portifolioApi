package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Habilidades;
import baseAPI.API.Sistema.Model.Instituicao;
import baseAPI.API.Sistema.Repository.HabilidadesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabilidadesService {

    @Autowired
    private HabilidadesRepository repository;

    public List<Habilidades> listar(){
        try {
            repository.findAll();
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Habilidades buscarPorId(Long id)
    {
        try {
            repository.findById(id);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Habilidades salvar(Habilidades habilidades, MultipartFile file)
    {
        try {
            if (habilidades != null)
            {
                if(file != null){
                    habilidades.setImagem(file.getBytes());
                }
                repository.save(habilidades);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Habilidades editar(Long id, Habilidades habilidades, MultipartFile file)
    {
        try {
            if(repository.existsById(id))
            {
                if (habilidades != null)
                {
                    if(file != null){
                        habilidades.setImagem(file.getBytes());
                    }
                    repository.save(habilidades);
                }
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Habilidades deletar(Long id)
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
