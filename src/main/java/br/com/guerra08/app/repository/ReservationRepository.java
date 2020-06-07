package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findAllByResource(Resource r);

    Integer countReservationsByEndDateIsAfterAndStartDateIsBefore(LocalDate start, LocalDate end);

}
