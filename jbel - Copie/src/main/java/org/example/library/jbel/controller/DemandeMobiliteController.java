package org.example.library.jbel.controller;

import org.example.library.jbel.entity.DemandeConge;
import org.example.library.jbel.entity.DemandeMobilite;
import org.example.library.jbel.repository.DemandeMobiliteRepository;
import org.example.library.jbel.service.impl.DemandeMobiliteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/demandemobilite/auth")
public class DemandeMobiliteController {

    @Autowired
    private DemandeMobiliteRepository demandeMobiliteRepository;
    private final DemandeMobiliteServ demandeMobiliteServ;

    public DemandeMobiliteController(DemandeMobiliteServ demandeMobiliteServ) {
        this.demandeMobiliteServ = demandeMobiliteServ;
    }

    @PostMapping("/save_demande_mobilite")
    public String saveDemandeMobilite(@ModelAttribute DemandeMobilite demandeMobilite) {
        // Save the DemandeConge object to the database

        demandeMobiliteServ.saveDemandeMobilte(demandeMobilite);
        // Redirect to a success page or another page
        return "redirect:/index";
    }

    // Create a new DemandeConge object with the submitted data



    @GetMapping
    public List<DemandeMobilite> getAllDemandesMobilite() {
        return demandeMobiliteRepository.findAll();
    }

}
