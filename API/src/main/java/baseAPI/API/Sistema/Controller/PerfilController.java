package baseAPI.API.Sistema.Controller;

import baseAPI.API.Sistema.Model.Perfil;
import baseAPI.API.Sistema.Service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/perfil")
@RequiredArgsConstructor
@Tag(name = "/api/perfil", description = "manipula dados referente a tabela perfil")
public class PerfilController {

    @Autowired
    private  final PerfilService service;

    @Operation(summary = "Busca todos os dados da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @GetMapping()
    public List<Perfil> ListarPerfil() {return  service.listar();}

    @Operation(summary = "Busca Registro por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @GetMapping("/{id}")
    public Perfil BuscaPerfilPorId(@RequestParam Long id){ return service.buscarPorId(id);}

    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @PostMapping()
    public Perfil novoPerfil(@RequestBody Perfil entidade, @RequestPart MultipartFile file){ return service.Salvar(entidade, file);}

    @Operation(summary = "Edita Registro da tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @PutMapping("/{id}")
    public Perfil EditarPerfil(@RequestParam Long id, @RequestBody Perfil entidade, @RequestPart MultipartFile file){ return  service.editar(id, entidade, file);}

    @Operation(summary = "Deleta Registro da tabela por id", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro deletado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @DeleteMapping("/{id}")
    public Perfil deletarPerfil(@RequestParam Long id){return service.deletar(id);}

}
