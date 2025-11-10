package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bombas")
public class BombasDeCombustivelController {

    private final BombasDeCombustivelService bombasDeCombustivelService;

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
    public ResponseEntity <String> criarBomba(@RequestBody BombasDeCombustivelDTO bomba) {
        BombasDeCombustivelDTO novaBomba = bombasDeCombustivelService.criarBomba(bomba);
       return ResponseEntity.status(HttpStatus.CREATED)
                .body("Bomba criada com sucesso: " + novaBomba.getNomeDaBomba() + " (ID): " + novaBomba.getId());

    }

    //mostrar todas as bombas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<BombasDeCombustivelDTO>> listarBombas() {
        List<BombasDeCombustivelDTO> bombas = bombasDeCombustivelService.listarBombas();
        return ResponseEntity.ok(bombas);
    }

    //mostrar bombas por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarBombasPorId(@PathVariable Long id) {
        BombasDeCombustivelDTO bombas = bombasDeCombustivelService.listarBombasPorId(id);
        if(bombas !=null) {
            return ResponseEntity.ok(bombas);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Bomba com id: " + id + " nao existe nos nossos registros");
        }
    }

    //alterar dados das bombas (UPDATE)
        @PutMapping("/alterar/{id}")
        public ResponseEntity<?> alterarBombaPorId(@PathVariable Long id, @RequestBody BombasDeCombustivelDTO bombaAtualizada) {
           BombasDeCombustivelDTO bombas =  bombasDeCombustivelService.atualizarBomba(id, bombaAtualizada);
           if (bombas != null) {
               return  ResponseEntity.ok(bombas);
           } else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body(" Bomba com id: " + id + " nao existe nos nossos registros");
           }
        }


    //deletar bomba (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarBombaPorId(@PathVariable Long id) {

        if ( bombasDeCombustivelService.listarBombasPorId(id) != null) {
            bombasDeCombustivelService.deletarBombaPorId(id);
            return ResponseEntity.ok("Bomba com o ID " + id + " deletado com sucesso");

        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Bomba com o id " + id + " nao encontrado");
        }

    }



}
