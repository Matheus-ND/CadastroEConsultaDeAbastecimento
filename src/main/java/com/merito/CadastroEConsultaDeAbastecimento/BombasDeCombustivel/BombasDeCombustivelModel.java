package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;


import com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel.TiposDeCombustivelModel;
import jakarta.persistence.*;

import java.util.List;

// Entity transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro_de_bombas_de_combustivel")
public class BombasDeCombustivelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaBomba;
    private String CombustivelQueAbastece;

    // Uma bomba pode ter varios tipos de combustiveis
    @OneToMany(mappedBy = "bombas")
    private TiposDeCombustivelModel tiposDeCombustivel;



    public BombasDeCombustivelModel(String nomeDaBomba, String combustivelQueAbastece) {
        this.nomeDaBomba = nomeDaBomba;
        this.CombustivelQueAbastece = combustivelQueAbastece;
    }

    public String getNomeDaBomba() {
        return nomeDaBomba;
    }

    public void setNomeDaBomba(String nomeDaBomba) {
        this.nomeDaBomba = nomeDaBomba;
    }

    public String getCombustivelQueAbastece() {
        return CombustivelQueAbastece;
    }

    public void setCombustivelQueAbastece(String combustivelQueAbastece) {
        CombustivelQueAbastece = combustivelQueAbastece;
    }
}
