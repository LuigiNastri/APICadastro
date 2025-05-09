package dev.nastriluigi.CadastroDeFuncionarios.Atividade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nastriluigi.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_atividade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AtividadeModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private NivelDificuldade dificuldade;

    // Uma atividade pode ter varios funcionarios
    @OneToMany(mappedBy = "atividade")
    @JsonIgnore
    private List<FuncionarioModel> funcionarios;


}
