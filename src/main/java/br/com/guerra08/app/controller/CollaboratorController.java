package br.com.guerra08.app.controller;

import br.com.guerra08.app.service.ICollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollaboratorController {

    private final ICollaboratorService collaboratorService;

    @Autowired
    public CollaboratorController(ICollaboratorService cs){
        this.collaboratorService = cs;
    }

    @GetMapping("/collaborators")
    public String getCollaborators(Model m){
        m.addAttribute("collaborators", collaboratorService.findAll());
        return "collaborators";
    }
}
