package org.example.library.jbel.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.library.jbel.entity.DemandeAugmentation;
import org.example.library.jbel.repository.DemandeAugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeAugImpl implements DemandAugServ {

    private final DemandeAugRepository demandeAugRepository;

    @Autowired
    public DemandeAugImpl(DemandeAugRepository demandeAugRepository) {
        this.demandeAugRepository = demandeAugRepository;
    }
    public List<DemandeAugmentation> getAllDemAug() {
        return demandeAugRepository.findAll();
    }

    // Méthode pour récupérer une demande de stage par son ID
    public DemandeAugmentation getDemAugById(Long id) {
        return demandeAugRepository.findById(id).orElse(null);
    }

    @Override
    public List<DemandeAugmentation> getAllDemandesAug() {
        return List.of();
    }

    @Override
    public DemandeAugmentation getDemandeAugById(Long id) {
        return null;
    }

    // Méthode pour enregistrer une nouvelle demande de stage
    // public DemandeConge saveDemandeConge(DemandeConge demandeConge) {
    //   return demandeCongeRepository.save(demandeConge);
    //}
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public DemandeAugmentation saveDemandeAug(DemandeAugmentation demandeAugmentation) {
        entityManager.persist(demandeAugmentation);
        return demandeAugmentation;
    }

    // Méthode pour mettre à jour une demande de stage existante
    public DemandeAugmentation updateDemandeAug(Long id, DemandeAugmentation nouvelleDemandeAug) {
        if (demandeAugRepository.existsById(id)) {
            nouvelleDemandeAug.setId(id); // Assurez-vous que l'ID est correctement défini pour la mise à jour
            return demandeAugRepository.save(nouvelleDemandeAug);
        }
        return null; // Ou lancez une exception appropriée si l'ID n'existe pas
    }

    // Méthode pour supprimer une demande de stage par son ID
    public void deleteDemandeAug(Long id) {
        demandeAugRepository.deleteById(id);
    }

    // Ajoutez ici les méthodes pour manipuler les demandes de congé, comme dans l'exemple précédent
}