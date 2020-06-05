package br.com.guerra08.app.controller;

import br.com.guerra08.app.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getResources(@RequestParam(required = false) String type, Model model){
        model.addAttribute("resources", resourceRepository.findAll());
        return "resources";
    }
}
