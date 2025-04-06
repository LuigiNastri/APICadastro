package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;
import dev.nastriluigi.CadastroDeFuncionarios.Atividade.AtividadeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
    private Long ID;
    private String nome;
    private String email;
    private int idade;
    private String cargo;
    private AtividadeModel atividade;
}
