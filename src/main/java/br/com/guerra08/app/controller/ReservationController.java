package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Reservation;
import br.com.guerra08.app.model.Resource;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ReservationController {

    private final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

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
                Data.reservations.add(r);
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao criar reserva. As datas não são válidas.");
        }
    }

    private boolean isReservedInDate(Resource resource, LocalDate start, LocalDate end){
        long occ = Data.reservations.stream().filter( e -> e.getEnd().isAfter(start) && e.getResource().getId().equals(resource.getId())).count();
        return occ > 0;
    }

    public String listAllReservations(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Data.reservations.size() ; i++) {
            sb.append(Data.reservations.get(i));
        }
        return sb.toString();
    }

    public String listCollaboratorOldReservations(Collaborator c){
        LocalDate date = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Data.reservations.size() ; i++) {
            if(Data.reservations.get(i).getStart().isBefore(date) && Data.reservations.get(i).getCollaboratorCode().equals(c.getCode())){
                sb.append(Data.reservations.get(i));
            }
        }
        return sb.toString();
    }

    public String listCollaboratorsTotalValue(){
        HashMap<Collaborator, Double> colTotalValue = new HashMap<>();
        Data.reservations.forEach(e -> {
            if(colTotalValue.get(e.getCollaborator()) == null){
                colTotalValue.put(e.getCollaborator(), e.getTotalCost());
            }
            else{
                colTotalValue.put(e.getCollaborator(), colTotalValue.get(e.getCollaborator()) + e.getTotalCost());
            }
        });
        StringBuilder sb = new StringBuilder();
        colTotalValue.forEach((k, v) -> sb.append("Colaborador ").append(k.getFullName()).append(", código ").append(k.getCode()).append(". Valor total: ").append(nf.format(v)).append("\n"));
        return sb.toString();
    }

    public String listResourceTotalValue(){
        HashMap<Resource, Double> resTotalValue = new HashMap<>();
        Data.reservations.forEach(e -> {
            if(resTotalValue.get(e.getResource()) == null){
                resTotalValue.put(e.getResource(), e.getTotalCost());
            }
            else{
                resTotalValue.put(e.getResource(), resTotalValue.get(e.getResource()) + e.getTotalCost());
            }
        });
        StringBuilder sb = new StringBuilder();
        resTotalValue.forEach((k, v) -> sb.append(k.toString()).append(". Valor total: ").append(nf.format(v)).append("\n"));
        return sb.toString();
    }

}
