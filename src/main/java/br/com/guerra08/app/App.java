package br.com.guerra08.app;

import br.com.guerra08.app.controller.CollaboratorController;
import br.com.guerra08.app.controller.ReservationController;
import br.com.guerra08.app.controller.ResourceController;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        CollaboratorController collaboratorController = new CollaboratorController();
        ResourceController resourceController = new ResourceController();
        ReservationController reservationController = new ReservationController();

        System.out.println(reservationController.getReservations().toString());

        reservationController.createReservation(collaboratorController.getCollaborator("54321"), resourceController.getResource("1"), LocalDate.of(2020, 6, 12), LocalDate.of(2020, 6, 15));
    }

}