package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {

        return "Essa é minha primeira mensagem nessa rota";
    }
        @PostMapping("/criar")
        @Operation(summary = "Cria um novo funcionario", description = "Rota cria um novo funcionario e insere no banco de dados")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Funcionario criado com sucesso"),
                @ApiResponse(responseCode = "400", description = "Erro na criação do funcionario")
        })
        public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionario){
        FuncionarioDTO novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso: " + novoFuncionario.getNome() + " (ID): " + novoFuncionario.getID());
        }

        @GetMapping("/listar")
        @Operation(summary = "Lista todos os funcionarios", description = "Rota lista todos funcionarios presentes no banco de dados")
        public ResponseEntity<List<FuncionarioDTO>> ListarFuncionarios(){
            List<FuncionarioDTO> funcionarios = funcionarioService.ListarFuncionarios();
            return ResponseEntity.ok(funcionarios);
            }
        @GetMapping("/listar/{id}")
        @Operation(summary = "Lista um funcionario por ID", description = "Rota lista um funcionario pelo ID presente no banco de dados")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Funcionario encontrado com sucesso"),
                @ApiResponse(responseCode = "400", description = "Funcionario não encontrado")
        })
        public ResponseEntity<?> ListarFuncporid(@PathVariable Long id){
        FuncionarioDTO funcionarios = funcionarioService.ListarFuncporid(id);
        if(funcionarios != null){
            return ResponseEntity.ok(funcionarios) ;
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionario com o ID: " + id + " não foi encontrado");
        }
        }

        @DeleteMapping("/deletar/{id}")
        @Operation(summary = "Deleta um funcionario por ID", description = "Rota Deleta um funcionario pelo ID presente no banco de dados")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Funcionario deletado com sucesso"),
                @ApiResponse(responseCode = "400", description = "Funcionario não encontrado")})
        public ResponseEntity<String> DeletarFuncID(@PathVariable Long id){
        if(funcionarioService.ListarFuncporid(id) != null){
            funcionarioService.DeletarFuncID(id);
            return ResponseEntity.ok("Funcionario com o ID " + id + " deletado com sucesso");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O Funcionario com o id " + id + " Não encontrado.");
        }
        }

        @PutMapping("/alterar/{id}")
        @Operation(summary= "Altera o funcionario por ID", description = "Rota altera um funcionario pelo seu ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Funcionario alterado com sucesso"),
                @ApiResponse(responseCode = "400", description = "Funcionario não encontrado, não foi possivel alterar")
        })
        public ResponseEntity<?> AtualizarFunc(@Parameter(description = "Usuario manda o id no caminho da requisicao") @PathVariable Long id,
                                               @Parameter(description = "Usuario manda os dados do funcionario a ser atualizado no corpo da Requisição")
                                               @RequestBody FuncionarioDTO funcionarioAtualizado){
        FuncionarioDTO funcionario = funcionarioService.AtualizarFunc(id, funcionarioAtualizado);
            if (funcionario != null) {
                return ResponseEntity.ok(funcionario);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("O Funcionario com o id (" + id + ") Não encontrado para realizar atualização.");
            }
    }

        }







