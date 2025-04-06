package dev.nastriluigi.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setID(funcionarioDTO.getID());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setCargo(funcionarioDTO.getCargo());
        funcionarioModel.setAtividade(funcionarioDTO.getAtividade());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setID(funcionarioModel.getID());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setCargo(funcionarioModel.getCargo());
        funcionarioDTO.setAtividade(funcionarioModel.getAtividade());
        return funcionarioDTO;
    }

}
