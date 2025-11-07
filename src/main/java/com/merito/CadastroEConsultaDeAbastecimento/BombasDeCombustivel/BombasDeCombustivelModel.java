package com.merito.CadastroEConsultaDeAbastecimento.BombasDeCombustivel;

import com.merito.CadastroEConsultaDeAbastecimento.TiposDeCombustivel.TiposDeCombustivelModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_de_bombas_de_combustivel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "tiposDeCombustivel")
public class BombasDeCombustivelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "nomeDaBomba") // não pode ter duas bombas com o mesmo nome
    private String nomeDaBomba;

    @Column(name = "img_Url")
    private String imgUrl;

    // Uma bomba pode ter vários tipos de combustíveis
    @ManyToMany
    @JoinTable(
            name = "bomba_combustivel", // Tabela de junção
            joinColumns = @JoinColumn(name = "bomba_id"), // Chave da bomba
            inverseJoinColumns = @JoinColumn(name = "tipo_combustivel_id") // Chave do tipo de combustível
    )
    private List<TiposDeCombustivelModel> tiposDeCombustivel;
}
