package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Resource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResourceRepository extends CrudRepository<Resource, Long> {

    Resource findById(long id);
    List<Resource> findAllByType(Integer type);

}
