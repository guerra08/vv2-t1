package br.com.guerra08.app.repository;

import br.com.guerra08.app.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
