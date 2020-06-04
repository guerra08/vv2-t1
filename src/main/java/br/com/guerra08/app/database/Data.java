package br.com.guerra08.app.database;

import br.com.guerra08.app.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static List<Collaborator> collaborators = new ArrayList<>();
    public static List<Resource> resources = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    public static void initCollaborators(){
        Collaborator c1 = new Collaborator("12345", "João da Silva", "jsilva@outlook.com");
        Collaborator c2 = new Collaborator("54321", "Marcos Júnior", "junior.m@gmail.com");
        Collaborator c3 = new Collaborator("11223", "Felipe Castro", "castrofelipe@yahoo.com");
        Collaborator c4 = new Collaborator("90998", "Pedro Silva", "psilva@hotmail.com");
        Collaborator c5 = new Collaborator("87866", "Luis Volpato", "volpluis@outlook.com");
        collaborators.addAll(Arrays.asList(c1,c2,c3,c4,c5));
    }

    public static void initResources(){
        Resource r1 = new Furniture("1", "Mesa", 15, "Mobília");
        Resource r2 = new Furniture("2", "Quadro", 17, "Mobília");
        Resource r3 = new MobileEquip("3", "Motorola G5", 25, "Smartphone");
        Resource r4 = new MobileEquip("4", "Laptop Dell", 40, "Computador");
        Resource r5 = new MobileEquip("5", "iPad", 40, "Tablet");
        Resource r6 = new Spaces("5", "Auditório", "Sala", 15, 60);
        resources.addAll(Arrays.asList(r1,r2,r3,r4,r5,r6));
    }

    public static void initReservations(){
        Reservation res1 = new Reservation(collaborators.get(0), resources.get(0), LocalDate.of(2020, 6, 5), LocalDate.of(2020, 6, 8));
        Data.reservations.add(res1);
    }
}
