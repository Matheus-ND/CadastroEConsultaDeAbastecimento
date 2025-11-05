package com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tiposDeCombustivel") //Mapeia as APIs
public class TiposDeCombustivelController {

    //GET -- Mandar uma requisicao para mostrar as Bombas
    @GetMapping("/listar")
    public String listarBomba(){
        return "Bombas listadas com sucesso";
    }

    //POST -- Mandar uma requisicao para criar as Bombas
    @PostMapping("/criar")
    public String criarBomba(){
        return "Bomba criada com sucesso";
    }

    //PUT-- Mandar uma requisicao para alterar as Bombas
    @PutMapping("/alterar")
    public String alterarBomba(){
        return "Bomba alterada com sucesso";
    }

    //DELETE -- Mandar uma requisicao para deletar as Bombas
    @DeleteMapping("/deletar")
    public String deletarBomba(){
        return "Bomba deletada com sucesso";
    }

}
