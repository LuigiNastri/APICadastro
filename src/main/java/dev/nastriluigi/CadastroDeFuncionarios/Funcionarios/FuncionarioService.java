package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

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

    public FuncionarioModel criarFuncionario(FuncionarioModel funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
