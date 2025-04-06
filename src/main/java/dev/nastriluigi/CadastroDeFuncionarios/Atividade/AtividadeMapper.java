package dev.nastriluigi.CadastroDeFuncionarios.Atividade;

import org.springframework.stereotype.Component;

@Component
public class AtividadeMapper {

    public AtividadeModel map(AtividadeDTO atividadeDTO){
        AtividadeModel atividadeModel = new AtividadeModel();
        atividadeModel.setId(atividadeDTO.getId());
        atividadeModel.setDescricao(atividadeDTO.getDescricao());
        atividadeModel.setDificuldade(atividadeDTO.getDificuldade());
        atividadeModel.setFuncionarios(atividadeDTO.getFuncionarios());

        return atividadeModel;
    }

    public AtividadeDTO map(AtividadeModel atividadeModel) {
        AtividadeDTO atividadeDTO = new AtividadeDTO();
        atividadeDTO.setId(atividadeModel.getId());
        atividadeDTO.setDescricao(atividadeModel.getDescricao());
        atividadeDTO.setDificuldade(atividadeModel.getDificuldade());
        atividadeDTO.setFuncionarios(atividadeModel.getFuncionarios());

        return atividadeDTO;
    }

}
