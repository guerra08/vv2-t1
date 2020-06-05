package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Long> {

    Resource findById(long id);

}
