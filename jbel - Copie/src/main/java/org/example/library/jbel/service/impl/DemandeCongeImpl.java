package org.example.library.jbel.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.library.jbel.entity.DemandeConge;
import org.example.library.jbel.repository.DemandeCongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeCongeImpl implements DemandCongeServ {

    private final DemandeCongeRepository demandeCongeRepository;

    @Autowired
    public DemandeCongeImpl(DemandeCongeRepository demandeCongeRepository) {
        this.demandeCongeRepository = demandeCongeRepository;
    }
    public List<DemandeConge> getAllDemConges() {
        return demandeCongeRepository.findAll();
    }

    // Méthode pour récupérer une demande de stage par son ID
    public DemandeConge getDemCongesById(Long id) {
        return demandeCongeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DemandeConge> getAllDemandesConge() {
        return List.of();
    }

    @Override
    public DemandeConge getDemandeCongeById(Long id) {
        return null;
    }

    // Méthode pour enregistrer une nouvelle demande de stage
   // public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
     //   return demandeCongeRepository.save(demandeConge);
    //}
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
        entityManager.persist(demandeConge);
        return demandeConge;
    }

    // Méthode pour mettre à jour une demande de stage existante
    public DemandeConge updateDemandeConge(Long id, DemandeConge nouvelleDemandeConge) {
        if (demandeCongeRepository.existsById(id)) {
            nouvelleDemandeConge.setId(id); // Assurez-vous que l'ID est correctement défini pour la mise à jour
            return demandeCongeRepository.save(nouvelleDemandeConge);
        }
        return null; // Ou lancez une exception appropriée si l'ID n'existe pas
    }

    // Méthode pour supprimer une demande de stage par son ID
    public void deleteDemandeConge(Long id) {
        demandeCongeRepository.deleteById(id);
    }

    // Ajoutez ici les méthodes pour manipuler les demandes de congé, comme dans l'exemple précédent
}