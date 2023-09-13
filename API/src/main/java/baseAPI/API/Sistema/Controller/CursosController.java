package baseAPI.API.Sistema.Controller;

import baseAPI.API.Sistema.Model.Cursos;
import baseAPI.API.Sistema.Model.Instituicao;
import baseAPI.API.Sistema.Service.CursoslService;
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
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
@Tag(name = "/api/cursos", description = "manipula dados referente a tabela cursos")
public class CursosController {

    @Autowired
    private final CursoslService service;

    @Operation(summary = "Busca todos os dados da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @GetMapping()
    public List<Cursos> ListarCursos() {return  service.listar();}

    @Operation(summary = "Busca Registro por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @GetMapping("/{id}")
    public Cursos BuscaInstituicaoPorId(@RequestParam Long id){ return service.buscarPorId(id);}

    @Operation(summary = "Salva Novo registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salvo realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @PostMapping()
    public Cursos novoCurso(@RequestBody Cursos entidade, @RequestPart MultipartFile file){ return service.salvar(entidade, file);}

    @Operation(summary = "Edita Registro da tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @PutMapping("/{id}")
    public Cursos EditarCurso(@RequestParam Long id, @RequestBody Cursos entidade, @RequestPart MultipartFile file){ return  service.editar(id, entidade, file);}

    @Operation(summary = "Deleta Registro da tabela por id", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registro deletado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
    })
    @DeleteMapping("/{id}")
    public Cursos deletarCursos(@RequestParam Long id){return service.deletar(id);}
}
