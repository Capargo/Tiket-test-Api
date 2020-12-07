package br.com.tiket.testapi.controller;

import br.com.tiket.testapi.controller.common.BaseController;
import br.com.tiket.testapi.response.EstadoResponse;
import br.com.tiket.testapi.response.common.BaseReturn;
import br.com.tiket.testapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController extends BaseController {

    @Autowired
    private EstadoService service;

    @GetMapping(produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<EstadoResponse> getEstado(@Valid @RequestHeader Long id){
        return service.getEstado(id);
    }
}
