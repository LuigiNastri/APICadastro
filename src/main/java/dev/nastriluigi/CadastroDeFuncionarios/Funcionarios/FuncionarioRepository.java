package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;

import dev.nastriluigi.CadastroDeFuncionarios.Atividade.AtividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
