package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
