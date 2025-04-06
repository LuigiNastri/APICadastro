package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class  AtividadeService {
    private final AtividadeRepository atividadeRepository;
    private final AtividadeMapper atividadeMapper;

    public AtividadeService(AtividadeRepository atividadeRepository, AtividadeMapper atividadeMapper) {
        this.atividadeRepository = atividadeRepository;
        this.atividadeMapper = atividadeMapper;
    }

    // Listar todas as atividades
    public List<AtividadeDTO> listarAtiv(){
    List<AtividadeModel> atividades = atividadeRepository.findAll();
    return atividades.stream()
            .map(atividadeMapper::map)
            .collect(Collectors.toList());
    }
    public AtividadeDTO listarAtivporID(Long id){
        Optional<AtividadeModel> atividadeporID = atividadeRepository.findById(id);
        return atividadeporID.map(atividadeMapper::map).orElse(null);
    }
    public AtividadeDTO criarAtiv(AtividadeDTO atividadeDTO){
        AtividadeModel atividade = new AtividadeMapper().map(atividadeDTO);
        atividade = atividadeRepository.save(atividade);
        return atividadeMapper.map(atividade);
    }
    public void deletarAtivPorID(Long id){
        atividadeRepository.deleteById(id);
    }
    public AtividadeDTO alterarAtiv(Long id, AtividadeDTO atividadeDTO) {
        Optional<AtividadeModel> atividadeExistente = atividadeRepository.findById(id);
        if (atividadeExistente.isPresent()){
            AtividadeModel atividadeAtualizado = atividadeMapper.map(atividadeDTO);
            atividadeAtualizado.setId(id);
            AtividadeModel atividadeSalvo = atividadeRepository.save(atividadeAtualizado);
            return atividadeMapper.map(atividadeSalvo);
        }
        return null;
    }
}
