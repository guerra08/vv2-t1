package br.com.guerra08.app.controller;

import br.com.guerra08.app.helpers.Formatting;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.service.ICollaboratorService;
import br.com.guerra08.app.service.IReservationService;
import br.com.guerra08.app.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    private final ICollaboratorService collaboratorService;
    private final IResourceService resourceService;
    private final IReservationService reservationService;

    @Autowired
    public ReservationController(ICollaboratorService cs, IResourceService rs, IReservationService resS){
        this.collaboratorService = cs;
        this.resourceService = rs;
        this.reservationService = resS;
    }

    @GetMapping("/create-reservation")
    public String getCreateReservationPage(Model m) {
        m.addAttribute("collaborators",collaboratorService.findAll());
        m.addAttribute("resources",resourceService.findAll());
        return "create-reservation";
    }

    @GetMapping("/manage-reservations")
    public String getManageReservationsPage(Model m) {
        m.addAttribute("reservations", reservationService.findAll());
        return "manage-reservations";
    }

    @PostMapping("/create-reservation")
    public ResponseEntity<String> createReservation(@RequestParam("collaborator") Collaborator coll, @RequestParam("resource") Resource res,
    @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){

        Reservation r = new Reservation(res, coll, Formatting.stringToLocalDate(startDate), Formatting.stringToLocalDate(endDate));
        Integer code = reservationService.save(r);
        return (code == 400) ? ResponseEntity.badRequest().body("Datas inválidas.") :
        (code == 409) ? ResponseEntity.status(409).body("Recurso já reservado.") :
        (code == 201) ? ResponseEntity.ok("Reserva cadastrada com sucesso!") : ResponseEntity.badRequest().body("Não foi possível realizar a operação.");
    }

    @DeleteMapping("/delete-reservation/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Reservation res){
        if(reservationService.deleteReservation(res)){
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().body("Invalid reservation");
    }

}
