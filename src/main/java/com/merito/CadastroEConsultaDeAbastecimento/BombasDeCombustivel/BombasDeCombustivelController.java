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
    public BombasDeCombustivelModel criarBomba(@RequestBody BombasDeCombustivelModel bomba){
        return bombasDeCombustivelService.criarBomba(bomba);
    }

    //mostrar todas as bombas (READ)
    @GetMapping("/listar")
    public List<BombasDeCombustivelModel> listarBombas(){
        return bombasDeCombustivelService.listarBombas();
    }

    //mostrar bombas por id (READ)
    @GetMapping("/listar/{id}")
    public BombasDeCombustivelModel listarBombasPorId(@PathVariable Long id) {
        return bombasDeCombustivelService.listarBombasPorId(id);
    }

    //alterar dados das bombas (UPDATE)
        @PutMapping("/alterarID")
        public String alterarBombaPorId() {
            return "Alterar Bomba por id";
        }


    //deletar bomba (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarBombaPorId() {
        return "Bomba deletada por id";
    }



}
