package br.com.guerra08.app.controller;

import br.com.guerra08.app.helpers.Formatting;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.repository.CollaboratorRepository;
import br.com.guerra08.app.repository.ReservationRepository;
import br.com.guerra08.app.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    private final CollaboratorRepository collaboratorRepository;
    private final ResourceRepository resourceRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(CollaboratorRepository cr, ResourceRepository rr, ReservationRepository resRepo){
        this.collaboratorRepository = cr;
        this.resourceRepository = rr;
        this.reservationRepository = resRepo;
    }

    @GetMapping("/create-reservation")
    public String getCreateReservationPage(Model m) {
        m.addAttribute("collaborators",collaboratorRepository.findAll());
        m.addAttribute("resources",resourceRepository.findAll());
        return "create-reservation";
    }

    @GetMapping("/manage-reservations")
    public String getManageReservationsPage(Model m) {
        m.addAttribute("reservations", reservationRepository.findAll());
        return "manage-reservations";
    }

    @PostMapping("/create-reservation")
    public String createReservation(@RequestParam("collaborator") Collaborator coll, @RequestParam("resource") Resource res,
                                  @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Model m){
        Reservation r = new Reservation(res, coll, Formatting.stringToLocalDate(startDate), Formatting.stringToLocalDate(endDate));
        reservationRepository.save(r);
        m.addAttribute("collaborators",collaboratorRepository.findAll());
        m.addAttribute("resources",resourceRepository.findAll());
        return "create-reservation";
    }

}
