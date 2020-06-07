package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Formatting;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = Reservation.TABLE_NAME)
public class Reservation{

    private final static String RESOURCE_REF = "resource_id";
    private final static String COLLABORATOR_REF = "collaborator_id";
    public final static String TABLE_NAME = "reservations";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name=Reservation.RESOURCE_REF)
    private Resource resource;
    @OneToOne
    @JoinColumn(name=Reservation.COLLABORATOR_REF)
    private Collaborator collaborator;
    private LocalDate startDate;
    private LocalDate endDate;

    protected Reservation(){}

    public Reservation(Resource resource, Collaborator collaborator, LocalDate startDate, LocalDate endDate) {
        this.resource = resource;
        this.collaborator = collaborator;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isFuture(){
        return (LocalDate.now()).isBefore(startDate);
    }

    public double getTotalCost(){ return Period.between(startDate, endDate).getDays() * resource.getUnitCost(); }

    public String getStringStartDate() { return Formatting.localDateToString(startDate); }

    public String getStringEndDate() { return Formatting.localDateToString(endDate); }
}