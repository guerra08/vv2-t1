package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Collaborator;
import org.springframework.data.repository.CrudRepository;

public interface CollaboratorRepository extends CrudRepository<Collaborator, Long> {
    Collaborator findByCode(String code);
    Collaborator findById(long id);
}