package org.example.library.jbel.controller;

import org.example.library.jbel.entity.DemandeAugmentation;
import org.example.library.jbel.entity.DemandeConge;
import org.example.library.jbel.repository.DemandeAugRepository;
import org.example.library.jbel.repository.DemandeCongeRepository;
import org.example.library.jbel.service.impl.DemandAugServ;
import org.example.library.jbel.service.impl.DemandCongeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demandeaug/auth")
public class DemandeAugController {

    @Autowired
    private DemandeAugRepository demandeAugRepository;
    private final DemandAugServ demandAugServ;


    public DemandeAugController(DemandAugServ demandAugServ) {
        this.demandAugServ = demandAugServ;
    }

    @PostMapping("/save_demande_aug")
    public String saveDemandeAug(@ModelAttribute DemandeAugmentation demandeAugmentation) {
        // Save the DemandeConge object to the database
        if (demandeAugmentation.getAugSalaire() == null) {
            demandeAugmentation.setAugSalaire(false);
        }

        // If augPrime checkbox is not checked, set it to false
        if (demandeAugmentation.getAugPrime() == null) {
            demandeAugmentation.setAugPrime(false);
        }
        demandAugServ.saveDemandeAug(demandeAugmentation);
        // Redirect to a success page or another page
        return "redirect:/index";
    }

    // Create a new DemandeConge object with the submitted data



    @GetMapping
    public List<DemandeAugmentation> getAllDemandesAug() {
        return demandeAugRepository.findAll();
    }

}
