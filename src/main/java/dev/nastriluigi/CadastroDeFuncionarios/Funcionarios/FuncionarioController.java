package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
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
    public String boasVindas() {

        return "Essa é minha primeira mensagem nessa rota";
    }
        @PostMapping("/criar")
        public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionario){
        FuncionarioDTO novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso: " + novoFuncionario.getNome() + " (ID): " + novoFuncionario.getID());
        }

        @GetMapping("/listar")
        public ResponseEntity<List<FuncionarioDTO>> ListarFuncionarios(){
            List<FuncionarioDTO> funcionarios = funcionarioService.ListarFuncionarios();
            return ResponseEntity.ok(funcionarios);
            }
        @GetMapping("/listar/{id}")
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
        public ResponseEntity<?> AtualizarFunc(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioAtualizado){
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







