package br.com.tiket.testapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResponse {

    private String nome;
    private Integer populacao;
    private Double custoPopulacionalCidadeDolar;
    private Double custoPopulacionalCidadeReal;
}
