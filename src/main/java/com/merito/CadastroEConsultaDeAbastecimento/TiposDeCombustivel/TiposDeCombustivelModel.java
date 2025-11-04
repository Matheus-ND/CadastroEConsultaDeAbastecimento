package com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel;

import com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel.BombasDeCombustivelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = " tb_tiposdecombustvel")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
