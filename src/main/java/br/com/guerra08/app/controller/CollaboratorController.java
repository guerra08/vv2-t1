package br.com.guerra08.app.controller;

import br.com.guerra08.app.repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollaboratorController {

    private final CollaboratorRepository collaboratorRepository;

    @Autowired
    public CollaboratorController(CollaboratorRepository cr){
        this.collaboratorRepository = cr;
    }

    @GetMapping("/collaborators")
    public String getCollaborators(Model m){
        m.addAttribute("collaborators", collaboratorRepository.findAll());
        return "collaborators";
    }
}
