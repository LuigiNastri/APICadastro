package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
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
         // Adicionar funcionario (Create)
        @PostMapping("/criar")
        public FuncionarioDTO criarFuncionario(@RequestBody FuncionarioDTO funcionario){
        return funcionarioService.criarFuncionario(funcionario);
        }

        // Mostrar Funcionario  (Read)
        @GetMapping("/listar")
        public List<FuncionarioDTO> ListarFuncionarios(){
            return funcionarioService.ListarFuncionarios();
            }
        // Mostrar todos os funcionarios por ID (Read)
        @GetMapping("/listar/{id}")
        public FuncionarioDTO ListarFuncporid(@PathVariable Long id){
            return funcionarioService.ListarFuncporid(id);
        }

        // Deletar Funcionarios (Delete)
        @DeleteMapping("/deletar/{id}")
        public void DeletarFuncID(@PathVariable Long id){
        funcionarioService.DeletarFuncID(id);
        }

        //Atualizar dados dos funcionarios (Update)
        @PutMapping("/alterar/{id}")
        public FuncionarioDTO AtualizarFunc(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioAtualizado){
        return funcionarioService.AtualizarFunc(id, funcionarioAtualizado);
    }

        }







