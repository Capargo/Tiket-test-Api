package br.com.tiket.testapi.repository;

import br.com.tiket.testapi.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Estado getById(Long id);
}
