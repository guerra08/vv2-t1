package br.com.guerra08.app.controller;

import br.com.guerra08.app.database.Data;
import br.com.guerra08.app.model.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ResourceController {

    public ResourceController(){
        Data.initResources();
    }

    @GetMapping("/resources")
    public String getResources(@RequestParam(required = false) String type, Model model){
        if(type != null && !(type = type.trim()).equals("")){
            model.addAttribute("resources", retrieveResourcesByType(type));
        }
        else{
            model.addAttribute("resources", Data.resources);
        }
        return "resources";
    }

    public Resource getResource(Resource r){
        return Data.resources.stream().filter(e -> e.getId().equals(r.getId())).findFirst().orElse(null);
    }

    public Resource getResource(String id){
        return Data.resources.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    private List<Resource> retrieveResourcesByType(String type) {
        return Data.resources.stream().filter(e -> e.getClass().getSimpleName().toLowerCase().equals(type.toLowerCase())).collect(Collectors.toList());
    }
}
