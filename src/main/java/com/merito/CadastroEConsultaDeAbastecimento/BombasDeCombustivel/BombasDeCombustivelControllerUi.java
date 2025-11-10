package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;
import com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel.TiposDeCombustivelModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/bombas/ui")
public class BombasDeCombustivelControllerUi {

    private final BombasDeCombustivelService bombasDeCombustivelService;

    public BombasDeCombustivelControllerUi(BombasDeCombustivelService bombasDeCombustivelService) {
        this.bombasDeCombustivelService = bombasDeCombustivelService;
    }

    @GetMapping("/listar")
    public String listarBombas(Model model) {
        List<BombasDeCombustivelDTO> bombas = bombasDeCombustivelService.listarBombas();
        model.addAttribute("bombas", bombas);
        return "listarBombas" ;
    }

    @GetMapping("/deletar/{id}")
    public String deletarBombaPorId(@PathVariable Long id) {
        bombasDeCombustivelService.deletarBombaPorId(id);
        return "redirect:/bombas/ui/listar";

        }

    @GetMapping("/listar/{id}")
    public String listarBombasPorId(@PathVariable Long id, Model model) {
        BombasDeCombustivelDTO bombas = bombasDeCombustivelService.listarBombasPorId(id);
        if(bombas !=null) {
            model.addAttribute("bombas", bombas);
            return "detalhesBomba";
        }else {
            model.addAttribute("mensagem", "Bomba nao encontrada");
            return "listarsBombas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarBomba(Model model) {
        model.addAttribute("bomba", new BombasDeCombustivelDTO());
        return "adicionarBomba";
    }

    @PostMapping("/salvar")
    public String salvarBomba(@ModelAttribute BombasDeCombustivelDTO bomba, RedirectAttributes redirectAttributes) {
        bombasDeCombustivelService.criarBomba(bomba);
        redirectAttributes.addFlashAttribute("mensagem", "Bomba cadastrada com sucesso!");
        return "redirect:/bombas/ui/listar";
    }


    @GetMapping("/alterar/{id}")
    public String alterarBombaPorId(@PathVariable Long id, Model model) {

        BombasDeCombustivelDTO bomba = bombasDeCombustivelService.listarBombasPorId(id);
        model.addAttribute("bomba", bomba);

        return "alterarBomba";
    }

    @PostMapping("/alterar")
    public String alterarBombaPorId(@ModelAttribute BombasDeCombustivelDTO bomba,
                                  RedirectAttributes redirectAttributes) {

        BombasDeCombustivelDTO atualizada = bombasDeCombustivelService.atualizarBomba(bomba.getId(), bomba);

        if (atualizada != null) {
            redirectAttributes.addFlashAttribute("message", "Bomba atualizada com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Bomba não encontrada!");
        }
        return "redirect:/bombas/ui/listar";
    }

    }

