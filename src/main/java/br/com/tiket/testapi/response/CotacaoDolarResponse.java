package br.com.tiket.testapi.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CotacaoDolarResponse {

    public List<ValueResponse> value;
}
