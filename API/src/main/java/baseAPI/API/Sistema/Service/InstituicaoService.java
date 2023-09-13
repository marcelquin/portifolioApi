package baseAPI.API.Sistema.Service;

import baseAPI.API.Sistema.Model.Instituicao;
import baseAPI.API.Sistema.Model.Perfil;
import baseAPI.API.Sistema.Repository.InstituicaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituicaoService {

    @Autowired
    private InstituicaoRepository repository;


    public List<Instituicao> listar(){
        try {
            repository.findAll();
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Instituicao buscarPorId(Long id)
    {
        try {
            repository.findById(id);
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Instituicao salvar(Instituicao instituicao, MultipartFile file)
    {
        try {
            if (instituicao != null)
            {
                if (file != null)
                {
                    instituicao.setLogo(file.getBytes());
                }
                repository.save(instituicao);
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Instituicao editar(Long id, Instituicao instituicao, MultipartFile file)
    {
        try {
            if(repository.existsById(id))
            {
                if (instituicao != null)
                {
                    if (file != null)
                    {
                        instituicao.setLogo(file.getBytes());
                    }
                    repository.save(instituicao);
                }
            }
        }catch (Exception e){
            new RuntimeException("ops, algo deu errado");
            e.getMessage();
        }
        return null;
    }

    public Instituicao deletar(Long id)
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
