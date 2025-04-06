package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import dev.nastriluigi.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {

    private Long id;
    private String descricao;
    private NivelDificuldade dificuldade;
    private List<FuncionarioModel> funcionarios;
}
