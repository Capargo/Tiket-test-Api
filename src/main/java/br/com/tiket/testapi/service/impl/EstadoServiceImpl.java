package br.com.tiket.testapi.service.impl;

import br.com.tiket.testapi.model.Cidade;
import br.com.tiket.testapi.model.Estado;
import br.com.tiket.testapi.repository.CidadeRepository;
import br.com.tiket.testapi.repository.EstadoRepository;
import br.com.tiket.testapi.request.EstadoRequest;
import br.com.tiket.testapi.response.CidadeResponse;
import br.com.tiket.testapi.response.EstadoResponse;
import br.com.tiket.testapi.response.common.BaseReturn;
import br.com.tiket.testapi.service.DolarService;
import br.com.tiket.testapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static br.com.tiket.testapi.util.ConstantUtils.*;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private DolarService dolarService;

    @Override
    public BaseReturn<EstadoResponse> getEstado(Long id) {

        Estado estado = estadoRepository.getById(id);
        List<Cidade> cidadeList = cidadeRepository.getAllByEstado(estado);

        List<CidadeResponse> cidadeResponseList = generateCidadeResponseList(cidadeList);

        Double custoPopulacaoEstadoDolar = calculateCustoPopulacaoEstado(cidadeResponseList);

        EstadoResponse data = new EstadoResponse();
        data.setNome(estado.nome);
        data.setCidadeList(cidadeResponseList);
        data.setCustoPopulacionalEstadoDolar(custoPopulacaoEstadoDolar);
        data.setCustoPopulacionalEstadoReal(dolarService.calculateRealValue(custoPopulacaoEstadoDolar));

        BaseReturn<EstadoResponse> response = new BaseReturn<>(data);

        return response;
    }

    private Double calculateCustoPopulacaoEstado(List<CidadeResponse> cidadeResponseList) {

        Double custoPopulacaoEstadoDolar = 0.0;

        for(CidadeResponse cidadeResponse : cidadeResponseList){
            custoPopulacaoEstadoDolar = custoPopulacaoEstadoDolar + cidadeResponse.getCustoPopulacionalCidadeDolar();
        }
        return custoPopulacaoEstadoDolar;
    }

    private List<CidadeResponse> generateCidadeResponseList(List<Cidade> cidadeList) {

        List<CidadeResponse> cidadeResponseList = new ArrayList<>();

        for(Cidade cidade : cidadeList){
            CidadeResponse cidadeResponse = new CidadeResponse();
            cidadeResponse.setNome(cidade.nome);
            cidadeResponse.setPopulacao(cidade.populacao);
            Double custo = calculateCustoPopulacaoCidade(cidade);
            cidadeResponse.setCustoPopulacionalCidadeDolar(custo);
            cidadeResponse.setCustoPopulacionalCidadeReal(dolarService.calculateRealValue(custo));
            cidadeResponseList.add(cidadeResponse);
        }
        return cidadeResponseList;
    }

    private Double calculateCustoPopulacaoCidade(Cidade cidade) {
      Double custoTotalCidadeDolar = CUSTO_CIDADAO_DOLAR;
      custoTotalCidadeDolar = custoTotalCidadeDolar * cidade.populacao;
        if(cidade.populacao>50000){
            custoTotalCidadeDolar = custoTotalCidadeDolar - (custoTotalCidadeDolar * REDUCAO_CUSTO_CIDADAO);
        }
        return custoTotalCidadeDolar;
    }


}
