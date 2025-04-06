package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividade")

public class AtividadeController {
    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @GetMapping("/listar")
    public List<AtividadeDTO> listarAtiv(){
        return atividadeService.listarAtiv();
    }
    @GetMapping("/listar/{id}")
    public AtividadeDTO listarAtivporID(@PathVariable Long id){
        return atividadeService.listarAtivporID(id);
    }

    @PostMapping("/criar")
    public AtividadeDTO criarAtiv(@RequestBody AtividadeDTO atividade){
        return atividadeService.criarAtiv(atividade);
    }

    @PutMapping("/alterar/{id}")
    public AtividadeDTO alterarAtiv(@PathVariable Long id, @RequestBody AtividadeDTO atividadeAtualizado){
        return atividadeService.alterarAtiv(id, atividadeAtualizado);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarAtivPorID(@PathVariable Long id){
        atividadeService.deletarAtivPorID(id);
    }

}
