package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar todos as minhas bombas por ID
    public BombasDeCombustivelModel listarBombasPorId(Long id) {
        Optional<BombasDeCombustivelModel> bombasPorId = bombasDeCombustivelRepository.findById(id);
        return bombasPorId.orElse(null);
    }

    //Criar uma nova bomba
    public BombasDeCombustivelModel criarBomba(BombasDeCombustivelModel bomba){
        return bombasDeCombustivelRepository.save(bomba);
    }

}
