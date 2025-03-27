package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FuncionarioController {
    @GetMapping("/boasvindas")
    public String boasVindas() {

        return "Essa é minha primeira mensagem nessa rota";
    }
         // Adicionar funcionario (Create)
        @PostMapping("/criar")
        public String criarFuncionario(){
            return "funcionario criado";
        }

        // Mostrar Funcionario por ID (Read)
        @GetMapping("/all")
        public String mostrarTodosFunc(){
            return "mostrar funcionario";
            }
        // Mostrar todos os Ninjas (Read)
        @GetMapping("/TodosID")
        public String mostrarTodosFuncporid(){
            return "mostrar funcionario por ID";
        }
         //Alterar dados dos funcionarios (Update)
        @PutMapping("/alterarID")
        public String AlterarFunc(){
            return "Alterar funcionario por ID";
        }
        // Deletar Funcionarios (Delete)
        @DeleteMapping("/deleterID")
        public String DeletarFuncID(){
            return "Deletar funcionario por ID";
        }

        }







