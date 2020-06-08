package br.com.guerra08.app;

import static org.junit.jupiter.api.Assertions.*;

import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.repository.CollaboratorRepository;
import br.com.guerra08.app.repository.ResourceRepository;
import br.com.guerra08.app.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservationServiceIntegrationTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    public void testFindAllReservations(){
        List<Reservation> allReservations = reservationService.findAll();
        assertTrue(allReservations.size() >= 1);
    }

    @Test
    public void testSaveInvalidReservationWithPreviousDates(){
        List<Resource> allResources = (List<Resource>)resourceRepository.findAll();
        List<Collaborator> allCollaborators = (List<Collaborator>)collaboratorRepository.findAll();
        Reservation toSave = new Reservation(allResources.get(3), allCollaborators.get(2), LocalDate.of(2020, 1, 15), LocalDate.of(2020, 1, 20));
        assertEquals(400, reservationService.save(toSave));
    }

    @Test
    public void testSaveInvalidReservationOfTypeFurnitureInvalidInterval(){
        List<Resource> allResources = resourceRepository.findAllByType(1);
        List<Collaborator> allCollaborators = (List<Collaborator>)collaboratorRepository.findAll();
        Reservation toSave = new Reservation(allResources.get(2), allCollaborators.get(2), LocalDate.of(2020, 7, 15), LocalDate.of(2020, 7, 17));
        assertEquals(400, reservationService.save(toSave));
    }

    @Test
    public void testSaveValidReservationOfTypeFurniture(){
        List<Resource> allResources = resourceRepository.findAllByType(1);
        List<Collaborator> allCollaborators = (List<Collaborator>)collaboratorRepository.findAll();
        Reservation toSave = new Reservation(allResources.get(2), allCollaborators.get(2), LocalDate.of(2020, 7, 15), LocalDate.of(2020, 7, 19));
        assertEquals(201, reservationService.save(toSave));
    }

    @Test
    public void testSaveInvalidReservedResource(){
        Reservation saved = reservationService.findAll().get(1);
        List<Collaborator> allCollaborators = (List<Collaborator>)collaboratorRepository.findAll();
        Reservation toSave = new Reservation(saved.getResource(), allCollaborators.get(2), saved.getStartDate().plus(Period.ofDays(1)), saved.getEndDate().plus(Period.ofDays(1)));
        assertEquals(409, reservationService.save(toSave));
    }

}
