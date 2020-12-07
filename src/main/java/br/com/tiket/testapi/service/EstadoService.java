package br.com.tiket.testapi.service;

import br.com.tiket.testapi.response.EstadoResponse;
import br.com.tiket.testapi.response.common.BaseReturn;

public interface EstadoService {

    BaseReturn<EstadoResponse> getEstado(Long id);
}
