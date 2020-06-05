package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Formatting;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Reservation {

   private Collaborator collaborator;
   private Resource resource;
   private LocalDate start;
   private LocalDate end;

   /**
    * Constructor for Reservation
    * @param collaborator The collaborator making the reservation
    * @param resource The resource being reserved
    * @param start The start Date
    * @param end The end Date
    */
   public Reservation(Collaborator collaborator, Resource resource, LocalDate start, LocalDate end) {
      if(start.isBefore(end)){
         this.collaborator = collaborator;
         this.resource = resource;
         this.start = start;
         this.end = end;
      }
      else{
         throw new IllegalArgumentException("Invalid dates");
      }
   }

   public String getCollaboratorCode(){
      return collaborator.getCode();
   }

   public Collaborator getCollaborator() {
      return collaborator;
   }

   public void setCollaborator(Collaborator collaborator) {
      this.collaborator = collaborator;
   }

   public Resource getResource() {
      return resource;
   }

   public void setResource(Resource resource) {
      this.resource = resource;
   }

   public LocalDate getStart() {
      return start;
   }

   public LocalDate getEnd() {
      return end;
   }

   public boolean isFuture(){
      return (LocalDate.now()).isBefore(start);
   }

   @Override
   public String toString(){
      return String.format("Reservation - Collaborator: %s - Resource: %s (Name: %s) - Start: %s - End: %s - Total cost: %s",
              this.collaborator.getCode(), this.resource.getId(), this.resource.getName(), this.start.toString(), this.end.toString(), Formatting.valueToCurrencyString(getTotalCost()));
   }

   public double getTotalCost(){
      return (Period.between(start, end).getDays() + 1) * resource.getUnitCost();
   }
}
