package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {

    List<Resource> findAllByType(Integer type);

}
