package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;


import com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel.TiposDeCombustivelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity transforma uma classe em uma entidade do BD
@Entity
@Table(name = "tb_cadastro_de_bombas_de_combustivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BombasDeCombustivelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "id")
    private Long id;

    @Column(unique = true) // nao pode ter duas bombas com o mesmo nome
    private String nomeDaBomba;

    @Column (name = "img_Url")
    private String imgUrl;

    @Column (name = "combustivelQueAbastece")
    private String combustivelQueAbastece;

    // Uma bomba pode ter varios tipos de combustiveis
    @OneToMany(mappedBy = "bombas")
    private TiposDeCombustivelModel tiposDeCombustivel;


}
