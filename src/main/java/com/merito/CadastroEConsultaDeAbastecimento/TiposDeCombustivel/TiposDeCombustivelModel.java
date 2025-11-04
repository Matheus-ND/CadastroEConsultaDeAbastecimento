package com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel;

import com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel.BombasDeCombustivelModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = " tb_tiposdecombustvel")
public class TiposDeCombustivelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nomeDoCombustivel ;
    private int precoPorLitro;

    // um tipo de combustivel pode ter uma bomba
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing key ou chave estrangeira
    private List<BombasDeCombustivelModel> bomba;




}
