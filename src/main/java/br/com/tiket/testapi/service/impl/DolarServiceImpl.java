package br.com.tiket.testapi.service.impl;

import br.com.tiket.testapi.api.DolarApi;
import br.com.tiket.testapi.response.CotacaoDolarResponse;
import br.com.tiket.testapi.response.ValueResponse;
import br.com.tiket.testapi.service.DolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DolarServiceImpl implements DolarService {

    @Autowired
    private DolarApi dolarApi;

    @Override
    public Double calculateRealValue(Double dolarValue) {

        CotacaoDolarResponse response = dolarApi.getCotacaoDolar();

        for(ValueResponse value : response.getValue()){
            System.out.println(value.cotacaoCompra);
        }

        return dolarValue/response.getValue().get(0).cotacaoCompra;
    }
}
