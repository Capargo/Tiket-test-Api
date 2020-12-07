package br.com.tiket.testapi.api;

import br.com.tiket.testapi.response.CotacaoDolarResponse;
import feign.Param;
import feign.RequestLine;

public interface DolarApi {

    @RequestLine("GET /v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='12-07-2020'")
    CotacaoDolarResponse getCotacaoDolar();

}
