package br.com.guerra08.app.controller;

import br.com.guerra08.app.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResourceController {

    private final IResourceService resourceService;

    @Autowired
    public ResourceController(IResourceService rs){
        this.resourceService = rs;
    }

    @GetMapping("/resources")
    public String getResources(@RequestParam(required = false) Integer type, Model model){
        try{
            if (type != null) {
                model.addAttribute("resources", resourceService.findAllByType(type));
            } else {
                model.addAttribute("resources", resourceService.findAll());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "resources";
    }

    @ExceptionHandler({ NumberFormatException.class})
    public String handleFormatException() {
        return "resources";
    }
}
