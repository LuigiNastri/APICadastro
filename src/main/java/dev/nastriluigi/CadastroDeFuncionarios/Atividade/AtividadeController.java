package dev.nastriluigi.CadastroDeFuncionarios.Atividade;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
//LOCALHOST:8080, quer criar uma rota

public class AtividadeController {


    // GET --  Mandar uma requisao para mostrar as atividade
    @GetMapping("/listar")
    public String listarAtividade(){
        return "Atividade Listadas";
    }
    // POST --  Mandar uma requisao para criar as atividade

    @PostMapping("/criar")
    public String criarAtividade(){
        return "Atividade criado";
    }
    // PUT --  Mandar uma requisao para alterar as atividade

    @PutMapping("/alterar")
    public String alterarAtividade(){
        return "Alterar atividade";
    }
    // Delete --  Mandar uma requisao para deletar as atividade

    @DeleteMapping("/deletar")
    public String deletarAtividade(){
        return "Deletar atividade";
    }

}
