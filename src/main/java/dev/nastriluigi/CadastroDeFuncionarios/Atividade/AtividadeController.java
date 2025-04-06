package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<AtividadeDTO>> listarAtiv(){
        List<AtividadeDTO> atividades = atividadeService.listarAtiv();
        return ResponseEntity.ok(atividades);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAtivporID(@PathVariable Long id){
        AtividadeDTO atividade = atividadeService.listarAtivporID(id);
        if (atividade != null){
            return ResponseEntity.ok(atividade);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Atividade com o ID: " + id + " não foi encontrada");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarAtiv(@RequestBody AtividadeDTO atividade) {
        AtividadeDTO novaAtividade = atividadeService.criarAtiv(atividade);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Atividade criada com sucesso: " + novaAtividade.getDescricao() + " (ID: " + novaAtividade.getId() + ")");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarAtiv(@PathVariable Long id, @RequestBody AtividadeDTO atividadeAtualizado) {
        AtividadeDTO atividade = atividadeService.alterarAtiv(id, atividadeAtualizado);
        if (atividade != null) {
            return ResponseEntity.ok(atividade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Atividade com o ID: " + id + " não encontrada para atualização");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAtivPorID(@PathVariable Long id) {
        if (atividadeService.listarAtivporID(id) != null) {
            atividadeService.deletarAtivPorID(id);
            return ResponseEntity.ok("Atividade com o ID " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Atividade com o ID " + id + " não encontrada");
        }
    }

}
