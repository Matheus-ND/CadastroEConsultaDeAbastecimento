package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BombasDeCombustivelService {

    private BombasDeCombustivelRepository bombasDeCombustivelRepository;
    private BombasDeCombustivelMapper bombasDeCombustivelMapper;

    public BombasDeCombustivelService(BombasDeCombustivelRepository bombasDeCombustivelRepository) {
        this.bombasDeCombustivelRepository = bombasDeCombustivelRepository;
    }

    public List<BombasDeCombustivelDTO> listarBombas() {
        List<BombasDeCombustivelModel> bombas = bombasDeCombustivelRepository.findAll();
        return bombas.stream()
                .map(bombasDeCombustivelMapper::map)
                 .collect(Collectors.toList());
    }

    public BombasDeCombustivelDTO listarBombasPorId(Long id) {
        Optional<BombasDeCombustivelModel> bombasPorId = bombasDeCombustivelRepository.findById(id);
        return bombasPorId.map(bombasDeCombustivelMapper::map).orElse(null);
    }

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
    public BombasDeCombustivelDTO atualizarBomba(Long id, BombasDeCombustivelDTO bombasDeCombustivelDTO) {
      Optional<BombasDeCombustivelModel> bombaExistente = bombasDeCombustivelRepository.findById(id);
      if (bombaExistente.isPresent()) {
          BombasDeCombustivelModel bombaAtualizada = bombasDeCombustivelMapper.map(bombasDeCombustivelDTO);
          bombaAtualizada.setId(id);
          BombasDeCombustivelModel bombaSalva = bombasDeCombustivelRepository.save(bombaAtualizada);
            return bombasDeCombustivelMapper.map(bombaSalva);

      }
      return null;
    }

}
