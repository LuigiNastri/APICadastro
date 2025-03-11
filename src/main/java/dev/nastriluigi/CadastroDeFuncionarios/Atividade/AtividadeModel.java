package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import dev.nastriluigi.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_atividade")
public class AtividadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private NivelDificuldade dificuldade;

    // Uma atividade pode ter varios funcionarios
    @OneToMany(mappedBy = "missoes")
    private List<FuncionarioModel> funcionarios;


}
