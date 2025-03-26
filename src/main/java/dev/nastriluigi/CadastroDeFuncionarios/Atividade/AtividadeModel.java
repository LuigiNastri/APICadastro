package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import dev.nastriluigi.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_atividade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private NivelDificuldade dificuldade;

    // Uma atividade pode ter varios funcionarios
    @OneToMany(mappedBy = "atividade")
    private List<FuncionarioModel> funcionarios;


}
