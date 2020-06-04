package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Collaborator;
import java.util.List;

public class CollaboratorController {

    public CollaboratorController(){
        Data.initCollaborators();
    }

    public boolean createCollaborator(Collaborator... cols){
        if(cols != null){
            boolean flag = false;
            for(Collaborator c : cols){
                flag = Data.collaborators.add(c);
                System.out.printf("%s has been created!\n", c.toString());
            }
            return flag;
        }
        return false;
    }

    public boolean deleteCollaborator(Collaborator c){
        if(c != null){
            return Data.collaborators.removeIf(n -> n.getCode().equals(c.getCode()));
        }
        return false;
    }

    public boolean deleteCollaborator(String code){
        if(code != null){
            return Data.collaborators.removeIf(n -> n.getCode().equals(code));
        }
        return false;
    }

    public boolean updateCollaborator(Collaborator c){
        if(c != null){
            Data.collaborators.stream().filter(e -> e.getCode().equals(c.getCode())).forEach(i -> {
                i.setEmail(c.getEmail());
                i.setFullName(c.getFullName());
            });
            return true;
        }
        return false;
    }

    public List<Collaborator> getCollaborators(){
        return Data.collaborators;
    }

    public Collaborator getCollaborator(String code){
        if(code != null){
            return Data.collaborators.stream().filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
        }
        return null;
    }

    public Collaborator getCollaborator(Collaborator c){
        if(c != null){
            return Data.collaborators.stream().filter(e -> e.getCode().equals(c.getCode())).findFirst().orElse(null);
        }
        return null;
    }

}
