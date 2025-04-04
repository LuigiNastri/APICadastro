package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class  AtividadeService {
    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    // Listar todas as atividades
    public List<AtividadeModel> listarAtiv(){
        return atividadeRepository.findAll();
    }

    // Listar todas as atividades por ID
    public AtividadeModel listarAtivporID(Long id){
        Optional<AtividadeModel> atividadeporID = atividadeRepository.findById(id);
        return atividadeporID.orElse(null);
    }

    public AtividadeModel criarAtiv(AtividadeModel atividade){
        return atividadeRepository.save(atividade);
    }

    public void deletarAtivPorID(Long id){
        atividadeRepository.deleteById(id);
    }
}
