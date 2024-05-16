package org.example.library.jbel.controller;

import org.example.library.jbel.entity.DemandeConge;
import org.example.library.jbel.repository.DemandeCongeRepository;
import org.example.library.jbel.service.impl.DemandCongeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demandeconge/auth")
public class DemandeCongeController {

    @Autowired
    private DemandeCongeRepository demandeCongeRepository;
    private final DemandCongeServ demandCongeService;

    public DemandeCongeController(DemandCongeServ demandCongeService) {
        this.demandCongeService = demandCongeService;
    }

    @PostMapping("/save_demande_conge")
    public String saveDemandeConge(@ModelAttribute DemandeConge demandeConge) {
        // Save the DemandeConge object to the database
        demandCongeService.saveDemandeConge(demandeConge);
        // Redirect to a success page or another page
        return "redirect:/index";
    }

        // Create a new DemandeConge object with the submitted data



    @GetMapping
    public List<DemandeConge> getAllDemandesConge() {
        return demandeCongeRepository.findAll();
    }

}
