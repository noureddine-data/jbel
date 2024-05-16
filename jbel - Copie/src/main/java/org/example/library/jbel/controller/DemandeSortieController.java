package org.example.library.jbel.controller;

import org.example.library.jbel.entity.DemandeConge;
import org.example.library.jbel.entity.DemandeSortie;

import org.example.library.jbel.repository.DemandeSortieRepository;

import org.example.library.jbel.service.impl.DemandeSortieServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demandesortie/auth")
public class DemandeSortieController {

    @Autowired
    private DemandeSortieRepository demandeSortieRepository;
    private final DemandeSortieServ demandeSortieServ;


    public DemandeSortieController(DemandeSortieServ demandeSortieServ) {
        this.demandeSortieServ = demandeSortieServ;
    }


    @PostMapping("/save_demande_sortie")
    public String saveDemandeSortie(@ModelAttribute DemandeSortie demandeSortie) {
        // Save the DemandeConge object to the database
        demandeSortieServ.saveDemandeSortie(demandeSortie);
        // Redirect to a success page or another page
        return "redirect:/index";
    }

    // Create a new DemandeConge object with the submitted data



    @GetMapping
    public List<DemandeSortie> getAllDemandesSortie() {
        return demandeSortieRepository.findAll();
    }

}
