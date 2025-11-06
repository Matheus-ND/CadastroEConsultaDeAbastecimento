package com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel.BombasDeCombustivelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="tb_tiposdecombustivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TiposDeCombustivelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoCombustivel;

    private Double precoPorLitro;

    // Um tipo de combustível pode ter várias bombas
    @ManyToMany(mappedBy = "tiposDeCombustivel")
    @JsonIgnore
    private List<BombasDeCombustivelModel> bombas;
}
