package controllers;

import database.Data;
import models.Collaborator;

import java.util.List;
import java.util.Optional;

public class CollaboratorController {

    public CollaboratorController(){
        Data.initCollaborators();
    }

    public void createCollaborator(Collaborator c){
        if(c != null){
            Data.collaborators.add(c);
            System.out.printf("%s has been created!\n", c.toString());
        }
    }

    public void deleteCollaborator(Collaborator c){
        if(c != null){
            Data.collaborators.removeIf(n -> n.getCode().equals(c.getCode()));
        }
    }

    public void deleteCollaborator(String code){
        if(code != null){
            Data.collaborators.removeIf(n -> n.getCode().equals(code));
        }
    }

    public void updateCollaborator(Collaborator c){
        if(c != null){
            Data.collaborators.stream().filter(e -> e.getCode().equals(c.getCode())).forEach(i -> {
                i.setEmail(c.getEmail());
                i.setFullName(c.getFullName());
            });
        }
    }

    public List<Collaborator> getCollaborators(){
        return Data.collaborators;
    }

    public Optional<Collaborator> getCollaborator(String code){
        if(code != null){
            return Data.collaborators.stream().filter(e -> e.getCode().equals(code)).findFirst();
        }
        return null;
    }

    public Optional<Collaborator> getCollaborator(Collaborator c){
        if(c != null){
            return Data.collaborators.stream().filter(e -> e.getCode().equals(c.getCode())).findFirst();
        }
        return null;
    }

}
