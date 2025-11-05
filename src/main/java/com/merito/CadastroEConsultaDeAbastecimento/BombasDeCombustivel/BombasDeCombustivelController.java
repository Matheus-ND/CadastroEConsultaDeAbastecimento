package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BombasDeCombustivelController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return " Mensagem ";
    }

    //CRRUD
    //adicionar bomba (CREATE)
    @PostMapping("/criar")
    public String criarBomba(){
        return "Bomba criada";
    }

    //mostrar todas as bombas (READ)
    @GetMapping("/todos")
    public String mostrarTodasAsBombas(){
        return "Mostrar Bomba";
    }

    //mostrar bombas por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodasAsBombasPorId() {
        return "Mostrar Bomba por id";
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
