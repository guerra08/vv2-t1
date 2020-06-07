package br.com.guerra08.app.service;

import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements IReservationService{

    private final ReservationRepository repository;

    @Autowired
    public ReservationService(ReservationRepository rr){
        this.repository = rr;
    }

    public Integer save(Reservation r){
        if(r.getStartDate().isBefore(LocalDate.now()) || r.getEndDate().isBefore(LocalDate.now())){
            return 400;
        }
        Integer count = repository.countReservationsByResourceAndEndDateIsAfterAndStartDateIsBefore(r.getResource(), r.getStartDate(), r.getEndDate());
        if(count > 0){
            return 409;
        }
        repository.save(r);
        return 201;

    }

    public List<Reservation> findAll(){
        return (List<Reservation>) repository.findAll();
    }

}
