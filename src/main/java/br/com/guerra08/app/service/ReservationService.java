package br.com.guerra08.app.service;

import br.com.guerra08.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository rr){
        this.repository = rr;
    }

}
