package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividade")
//LOCALHOST:8080, quer criar uma rota

public class AtividadeController {
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    // GET --  Mandar uma requisao para mostrar as atividade
    @GetMapping("/listar")
    public List<AtividadeModel> listarAtiv(){
        return atividadeService.listarAtiv();
    }
    // Listar por ID
    @GetMapping("/listar/{id}")
    public AtividadeModel listarAtivporID(@PathVariable Long id){
        return atividadeService.listarAtivporID(id);
    }
    // POST --  Mandar uma requisao para criar as atividade

    @PostMapping("/criar")
    public AtividadeModel criarAtiv(@RequestBody AtividadeModel atividade){
        return atividadeService.criarAtiv(atividade);
    }
    // PUT --  Mandar uma requisao para alterar as atividade

    @PutMapping("/alterar")
    public String alterarAtividade(){
        return "Alterar atividade";
    }
    // Delete --  Mandar uma requisao para deletar as atividade
    @DeleteMapping("/deletar/{id}")
    public void deletarAtivPorID(@PathVariable Long id){
        atividadeService.deletarAtivPorID(id);
    }

}
