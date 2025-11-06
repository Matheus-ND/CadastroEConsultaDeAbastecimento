package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BombasDeCombustivelService {

    private BombasDeCombustivelRepository bombasDeCombustivelRepository;
    private BombasDeCombustivelMapper bombasDeCombustivelMapper;

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
    public BombasDeCombustivelDTO criarBomba(BombasDeCombustivelDTO bombaDTO) {
        BombasDeCombustivelModel bomba = bombasDeCombustivelMapper.map(bombaDTO);
        bomba = bombasDeCombustivelRepository.save(bomba);
        return bombasDeCombustivelMapper.map(bomba);
    }

    //Deletar a bomba - Tem que ser VOID
    public void deletarBombaPorId(Long id) {
        bombasDeCombustivelRepository.deleteById(id);
    }

    //Atualizar bomba
    public BombasDeCombustivelModel atualizarBomba(Long id, BombasDeCombustivelModel bombaAtualizada) {
        if (bombasDeCombustivelRepository.existsById(id)){
            bombaAtualizada.setId(id);
            return bombasDeCombustivelRepository.save(bombaAtualizada);
        }
return null;
    }

}
