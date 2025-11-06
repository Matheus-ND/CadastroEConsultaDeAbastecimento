package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;
import com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel.TiposDeCombustivelModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BombasDeCombustivelDTO {

    private Long id;
    private String nomeDaBomba;
    private String imgUrl;
    private List<TiposDeCombustivelModel> tiposDeCombustivel;

}
