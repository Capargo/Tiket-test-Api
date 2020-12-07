package br.com.tiket.testapi.response;

import br.com.tiket.testapi.model.Cidade;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EstadoResponse {

    private String nome;
    private String url;
    private List<CidadeResponse> cidadeList;
    private Double custoPopulacionalEstadoDolar;
    private Double custoPopulacionalEstadoReal;


}
