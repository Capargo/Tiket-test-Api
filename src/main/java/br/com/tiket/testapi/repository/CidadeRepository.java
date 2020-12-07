package br.com.tiket.testapi.repository;

import br.com.tiket.testapi.model.Cidade;
import java.util.List;

import br.com.tiket.testapi.model.Estado;
import org.springframework.data.repository.CrudRepository;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {

    List<Cidade> getAllByEstado(Estado estado);
}
