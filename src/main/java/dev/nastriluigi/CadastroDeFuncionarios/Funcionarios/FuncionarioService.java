package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioService(FuncionarioMapper funcionarioMapper) {
        this.funcionarioMapper = funcionarioMapper;
    }

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    // Listar todos os meus funcionarios
    public List<FuncionarioModel> ListarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    //Listar todos os meus funcionarios por ID
    public FuncionarioModel ListarFuncporid(Long id){
        Optional<FuncionarioModel> funcionarioPorId = funcionarioRepository.findById(id);
        return funcionarioPorId.orElse(null);
    }
    // Criar um novo funcionario
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionario = new FuncionarioMapper().map(funcionarioDTO);
        funcionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    // Deletar um funcionario = Tem que ser um metodo VOID
    public void DeletarFuncID(Long id){
        funcionarioRepository.deleteById(id);
    }

    // Atualizar Funcionario
    public FuncionarioModel AtualizarFunc(Long id, FuncionarioModel funcionarioAtualizado){
         if(funcionarioRepository.existsById(id)){
             funcionarioAtualizado.setID(id);
             return funcionarioRepository.save(funcionarioAtualizado);
         }
         return null;
    }

}
