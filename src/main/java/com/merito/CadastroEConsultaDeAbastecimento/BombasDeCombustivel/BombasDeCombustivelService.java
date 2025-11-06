package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BombasDeCombustivelService {

    private BombasDeCombustivelRepository bombasDeCombustivelRepository;

    public BombasDeCombustivelService(BombasDeCombustivelRepository bombasDeCombustivelRepository) {
        this.bombasDeCombustivelRepository = bombasDeCombustivelRepository;
    }

    //Listar todas as minhas Bombas
    public List<BombasDeCombustivelModel> listarBombas() {
        return bombasDeCombustivelRepository.findAll();
    }


}
