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
        public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionario){
        return funcionarioService.criarFuncionario(funcionario);
        }

        // Mostrar Funcionario  (Read)
        @GetMapping("/listar")
        public List<FuncionarioModel> ListarFuncionarios(){
            return funcionarioService.ListarFuncionarios();
            }
        // Mostrar todos os funcionarios por ID (Read)
        @GetMapping("/listar/{id}")
        public FuncionarioModel ListarFuncporid(@PathVariable Long id){
            return funcionarioService.ListarFuncporid(id);
        }
         //Alterar dados dos funcionarios (Update)
        @PutMapping("/alterar/{id}")
        public String AlterarFunc(){
            return "Alterar funcionario por ID";
        }
        // Deletar Funcionarios (Delete)
        @DeleteMapping("/deletar/{id}")
        public void DeletarFuncID(@PathVariable Long id){
        funcionarioService.DeletarFuncID(id);
        }
        }







