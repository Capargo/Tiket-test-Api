package br.com.tiket.testapi.factory;

import br.com.tiket.testapi.api.DolarApi;
import br.com.tiket.testapi.util.DateUtil;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DolarApiFactory {

    @Bean
    public DolarApi dolarApi() {

        int connectTimeoutMillis = 10000;
        int readTimeoutMillis = 10000;
        String host = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao";

        return Feign.builder().options(new Request.Options(connectTimeoutMillis, readTimeoutMillis))
                .logLevel(Logger.Level.BASIC)
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(DolarApi.class, host);
    }
}
