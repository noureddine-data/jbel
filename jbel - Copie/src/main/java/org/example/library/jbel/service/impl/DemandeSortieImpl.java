package org.example.library.jbel.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.library.jbel.entity.DemandeSortie;
import org.example.library.jbel.repository.DemandeSortieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeSortieImpl implements DemandeSortieServ {


    @Autowired
    private final DemandeSortieRepository demandeSortieRepository;

    public DemandeSortieImpl(DemandeSortieRepository demandeSortieRepository) {
        this.demandeSortieRepository = demandeSortieRepository;
    }


    public List<DemandeSortie> getAllDemandesSortie() {
        return demandeSortieRepository.findAll();
    }

    // Méthode pour récupérer une demande de stage par son ID
    public DemandeSortie getDemandeSortieById(Long id) {
        return demandeSortieRepository.findById(id).orElse(null);
    }

    @Override
    public List<DemandeSortie> saveDemandeSortie() {
        return List.of();
    }




    // Méthode pour enregistrer une nouvelle demande de stage
    // public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
    //   return demandeCongeRepository.save(demandeConge);
    //}
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public DemandeSortie saveDemandeSortie(DemandeSortie demandeSortie) {
        entityManager.persist(demandeSortie);
        return demandeSortie;
    }

    // Méthode pour mettre à jour une demande de stage existante
    public DemandeSortie updateDemandeSortie(Long id, DemandeSortie nouvelleDemandeSortie) {
        if (demandeSortieRepository.existsById(id)) {
            nouvelleDemandeSortie.setId(id); // Assurez-vous que l'ID est correctement défini pour la mise à jour
            return demandeSortieRepository.save(nouvelleDemandeSortie);
        }
        return null; // Ou lancez une exception appropriée si l'ID n'existe pas
    }

    // Méthode pour supprimer une demande de stage par son ID
    public void deleteDemandeSortie(Long id) {
        demandeSortieRepository.deleteById(id);
    }
}
