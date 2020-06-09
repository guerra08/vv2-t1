package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Collaborator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, Long> {

}