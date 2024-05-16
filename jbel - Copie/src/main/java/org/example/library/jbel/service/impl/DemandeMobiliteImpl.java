package org.example.library.jbel.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.example.library.jbel.entity.DemandeMobilite;

import org.example.library.jbel.repository.DemandeMobiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeMobiliteImpl implements DemandeMobiliteServ{
    private final DemandeMobiliteRepository demandeMobiliteRepository;

    @Autowired
    public DemandeMobiliteImpl(DemandeMobiliteRepository demandeMobiliteRepository) {
        this.demandeMobiliteRepository = demandeMobiliteRepository;
    }
    public List<DemandeMobilite> getAllDemandesMobilite() {
        return demandeMobiliteRepository.findAll();
    }


    // Méthode pour récupérer une demande de stage par son ID
    public DemandeMobilite getDemandeMobiliteById(Long id) {
        return demandeMobiliteRepository.findById(id).orElse(null);
    }

    // Méthode pour enregistrer une nouvelle demande de stage
    // public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
    //   return demandeCongeRepository.save(demandeConge);
    //}
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public DemandeMobilite saveDemandeMobilte(DemandeMobilite demandeMobilite) {
        entityManager.persist(demandeMobilite);
        return demandeMobilite;
    }

    // Méthode pour mettre à jour une demande de stage existante
    public DemandeMobilite updateDemandeMobilite(Long id, DemandeMobilite nouvelleDemandeMobilite) {
        if (demandeMobiliteRepository.existsById(id)) {
            nouvelleDemandeMobilite.setId(id); // Assurez-vous que l'ID est correctement défini pour la mise à jour
            return demandeMobiliteRepository.save(nouvelleDemandeMobilite);
        }
        return null; // Ou lancez une exception appropriée si l'ID n'existe pas
    }

    // Méthode pour supprimer une demande de stage par son ID
    public void deleteDemandeMobilite(Long id) {
        demandeMobiliteRepository.deleteById(id);
    }
}
