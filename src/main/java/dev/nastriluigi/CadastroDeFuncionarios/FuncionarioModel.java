package dev.nastriluigi.CadastroDeFuncionarios;

import jakarta.persistence.*;

// Transforma uma classe em uma Entidade do BD
@Entity
@Table(name = "tb_cadastro")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String nome;
    private String email;
    private int idade;

    public FuncionarioModel() {
    }

    public FuncionarioModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
