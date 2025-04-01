package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;

import dev.nastriluigi.CadastroDeFuncionarios.Atividade.AtividadeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Transforma uma classe em uma Entidade do BD

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long ID;

    @Column (name = "nome")
    private String nome;

    @Column(unique = true, name = "email")
    private String email;

    @Column (name = "idade")
    private int idade;



    // Um funcionario tem uma unica atividade
    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private AtividadeModel atividade;


}
