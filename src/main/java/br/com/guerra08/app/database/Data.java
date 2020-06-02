package br.com.guerra08.app.database;

import br.com.guerra08.app.model.Resource;
import br.com.guerra08.app.model.Collaborator;
import br.com.guerra08.app.model.Furniture;
import br.com.guerra08.app.model.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    public static List<Collaborator> collaborators = new ArrayList<>();
    public static List<Resource> resources = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    public static void initCollaborators(){
        Collaborator c1 = new Collaborator("12345", "Bruno Guerra", "gguerrabruno@outlook.com");
        Collaborator c2 = new Collaborator("54321", "Juca Gava", "jucagava@gmail.com");
        collaborators.addAll(Arrays.asList(c1,c2));
    }

    public static void initResources(){
        Resource r1 = new Furniture("1", "Mesa", 15, "Mobília");
        Resource r2 = new Furniture("2", "Quadro", 17, "Mobília");
        resources.addAll(Arrays.asList(r1,r2));
    }
}
