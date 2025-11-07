package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class BombasDeCombustivelController {

    private BombasDeCombustivelService bombasDeCombustivelService;

    public BombasDeCombustivelController(BombasDeCombustivelService bombasDeCombustivelService) {
        this.bombasDeCombustivelService = bombasDeCombustivelService;
    }

    @GetMapping("/bombas")
    public String boasVindas() {
        return " Mensagem ";
    }

    //CRRUD
    //adicionar bomba (CREATE)
    @PostMapping("/criar")
    public BombasDeCombustivelDTO criarBomba(@RequestBody BombasDeCombustivelDTO bomba){
        return bombasDeCombustivelService.criarBomba(bomba);
    }

    //mostrar todas as bombas (READ)
    @GetMapping("/listar")
    public List<BombasDeCombustivelDTO> listarBombas() {
        return bombasDeCombustivelService.listarBombas();
    }

    //mostrar bombas por id (READ)
    @GetMapping("/listar/{id}")
    public BombasDeCombustivelDTO listarBombasPorId(@PathVariable Long id) {
        return bombasDeCombustivelService.listarBombasPorId(id);
    }

    //alterar dados das bombas (UPDATE)
        @PutMapping("/alterar/{id}")
        public BombasDeCombustivelDTO alterarBombaPorId(@PathVariable Long id, @RequestBody BombasDeCombustivelDTO bombaAtualizada) {
            return bombasDeCombustivelService.atualizarBomba(id, bombaAtualizada);
        }


    //deletar bomba (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarBombaPorId(@PathVariable Long id) {
        bombasDeCombustivelService.deletarBombaPorId(id);
    }



}
