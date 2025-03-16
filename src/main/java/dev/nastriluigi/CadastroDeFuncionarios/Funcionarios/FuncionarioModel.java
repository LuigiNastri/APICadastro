package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;

import dev.nastriluigi.CadastroDeFuncionarios.Atividade.AtividadeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Transforma uma classe em uma Entidade do BD

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // Um funcionario tem uma unica atividade
    @ManyToOne
    @JoinColumn(name = "atividade.id")
    private AtividadeModel atividade;


}
