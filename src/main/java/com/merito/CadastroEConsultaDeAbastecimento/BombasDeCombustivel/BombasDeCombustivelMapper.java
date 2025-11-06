package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;
import org.springframework.stereotype.Component;

@Component
public class BombasDeCombustivelMapper {

    public BombasDeCombustivelModel map(BombasDeCombustivelDTO bombasDeCombustivelDTO) {
        BombasDeCombustivelModel bombasDeCombustivelModel = new BombasDeCombustivelModel();
        bombasDeCombustivelModel.setId(bombasDeCombustivelDTO.getId());
        bombasDeCombustivelModel.setNomeDaBomba(bombasDeCombustivelDTO.getNomeDaBomba());
        bombasDeCombustivelModel.setImgUrl(bombasDeCombustivelDTO.getImgUrl());
        bombasDeCombustivelModel.setTiposDeCombustivel(bombasDeCombustivelDTO.getTiposDeCombustivel());

        return bombasDeCombustivelModel;
    }
    public BombasDeCombustivelDTO map(BombasDeCombustivelModel bombasDeCombustivelModel) {

        BombasDeCombustivelDTO bombasDeCombustivelDTO = new BombasDeCombustivelDTO();
        bombasDeCombustivelDTO.setId(bombasDeCombustivelModel.getId());
        bombasDeCombustivelDTO.setNomeDaBomba(bombasDeCombustivelModel.getNomeDaBomba());
        bombasDeCombustivelDTO.setImgUrl(bombasDeCombustivelModel.getImgUrl());
        bombasDeCombustivelDTO.setTiposDeCombustivel(bombasDeCombustivelModel.getTiposDeCombustivel());

        return bombasDeCombustivelDTO;
    }
}
