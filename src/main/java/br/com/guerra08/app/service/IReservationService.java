package br.com.guerra08.app.service;

import br.com.guerra08.app.model.Reservation;

import java.util.List;

public interface IReservationService {

    Integer save(Reservation r);

    List<Reservation> findAll();

}
