package br.com.guerra08.app.service;

import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.repository.CollaboratorRepository;
import br.com.guerra08.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaboratorService implements ICollaboratorService{

    private final CollaboratorRepository collaboratorRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public CollaboratorService(CollaboratorRepository cr, ReservationRepository rr){
        this.collaboratorRepository = cr;
        this.reservationRepository = rr;
    }

    @Override
    public List<Collaborator> findAll() {
        return (List<Collaborator>) collaboratorRepository.findAll();
    }

}
