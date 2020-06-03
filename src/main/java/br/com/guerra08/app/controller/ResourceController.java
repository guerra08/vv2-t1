package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Resource;

import java.util.List;

public class ResourceController {

    public ResourceController(){
        Data.initResources();
    }

    public List<Resource> getResources(){
        return Data.resources;
    }

    public Resource getResource(Resource r){
        return Data.resources.stream().filter(e -> e.getId().equals(r.getId())).findFirst().orElse(null);
    }

    public Resource getResource(String id){
        return Data.resources.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean createResource(Resource... res){
        if(res != null){
            boolean flag = false;
            for(Resource r : res){
                flag = Data.resources.add(r);
                System.out.printf("%s has been created!\n", r.toString());
            }
            return flag;
        }
        return false;
    }

    public boolean updateResource(Resource r){
        if(r != null){
            for (int i = 0; i < Data.resources.size(); i++) {
                if(Data.resources.get(i).getId().equals(r.getId())){
                    Data.resources.set(i, r);
                    return true;
                }
            }
        }
        return false;
    }

}
