package br.com.guerra08.app.controller;

import br.com.guerra08.app.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResourceController {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceController(ResourceRepository rr){
        this.resourceRepository = rr;
    }

    @GetMapping("/resources")
    public String getResources(@RequestParam(required = false) Integer type, Model model){
        try{
            if (type != null) {
                model.addAttribute("resources", resourceRepository.findAllByType(type));
            } else {
                model.addAttribute("resources", resourceRepository.findAll());
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
