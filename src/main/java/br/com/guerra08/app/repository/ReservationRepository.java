package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByResource(Resource r);

    Integer countReservationsByResourceAndEndDateIsAfterAndStartDateIsBefore(Resource r, LocalDate start, LocalDate end);

    List<Reservation> findAllByCollaborator(Collaborator c);

}
