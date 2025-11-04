package com.merito.CadastroEConsultaDeAbastecimento;


import jakarta.persistence.*;

// Entity transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro_de_bombas_de_combustivel")
public class BombasDeCombustivelModel {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nomeDaBomba;
    String CombustivelQueAbastece;


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
