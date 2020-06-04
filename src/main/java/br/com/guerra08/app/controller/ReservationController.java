package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;

import java.time.LocalDate;
import java.util.List;

public class ReservationController {

    public ReservationController(){
        Data.initReservations();
    }

    public List<Reservation> getReservations(){
        return Data.reservations;
    }

    public void createReservation(Collaborator collaborator, Resource resource, LocalDate start, LocalDate end){
        try{
            Reservation r = new Reservation(collaborator, resource, start, end);
            if(!isReservedInDate(resource, start, end)){
                System.out.println("Pode reservar fera!");
            }
            else{
                System.out.println("Moiou!");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao criar reserva. As datas não são válidas.");
        }
    }

    private boolean isReservedInDate(Resource resource, LocalDate start, LocalDate end){
        long occ = Data.reservations.stream().filter( e -> e.getEnd().isAfter(start) && e.getResource().getId().equals(resource.getId())).count();
        return occ > 0;
    }

    public void listAllReservations(){
        System.out.println();
        for (int i = 0; i < Data.reservations.size() ; i++) {
            System.out.println(Data.reservations.get(i));
        }
    }

    public void listCollaboratorOldReservations(Collaborator c){
        LocalDate date = LocalDate.now();
        System.out.println("Collaborator: " + c.getCode());
        System.out.println("Old Reservations: ");
        for (int i = 0; i < Data.reservations.size() ; i++) {
            if(Data.reservations.get(i).getStart().isBefore(date) && Data.reservations.get(i).getCollaboratorCode().equals(c.getCode())){
                System.out.println(Data.reservations.get(i));
            }
        }
    }

    public void listCollaboratorsCosts(){
        for (int i = 0; i < Data.reservations.size(); i++) {

        }
    }

}
