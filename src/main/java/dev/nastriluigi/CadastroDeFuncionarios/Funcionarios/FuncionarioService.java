package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    public List<FuncionarioDTO> ListarFuncionarios(){
        List<FuncionarioModel> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(funcionarioMapper::map)
                .collect(Collectors.toList());
    }

    public FuncionarioDTO ListarFuncporid(Long id){
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);
        return funcionarioPorId.map(funcionarioMapper::map).orElse(null);
    }
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionario = new FuncionarioMapper().map(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    public void DeletarFuncID(Long id){
        funcionarioRepository.deleteById(id);
    }
    public FuncionarioDTO AtualizarFunc(Long id, FuncionarioDTO funcionarioDTO){
        Optional<FuncionarioModel> funcionarioExistente = funcionarioRepository.findById(id);
        if (funcionarioExistente.isPresent()){
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.map(funcionarioDTO);
            funcionarioAtualizado.setID(id);
            FuncionarioModel funcionarioSalvo = funcionarioRepository.save(funcionarioAtualizado);
            return funcionarioMapper.map(funcionarioSalvo);
        }
        return null;
    }

}
