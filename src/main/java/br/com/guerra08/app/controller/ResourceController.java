package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResourceController {

    public ResourceController(){
        Data.initResources();
    }

    @GetMapping("/resources")
    public String getResources(){
        return "resources";
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

    public String listResources() {
        StringBuilder sb = new StringBuilder();
        Data.resources.forEach( e -> {
            sb.append(e).append("\n");
        });
        return sb.toString();
    }

    public String listResourcesByType(String type) {
        StringBuilder sb = new StringBuilder();
        Data.resources.forEach(e -> {
            if(e.getClass().getSimpleName().equals(type)){
                sb.append(e).append("\n");
            }
        });

        return sb.toString();
    }

}
