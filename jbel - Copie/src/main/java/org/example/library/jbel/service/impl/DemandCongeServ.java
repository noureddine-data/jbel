package org.example.library.jbel.service.impl;

import org.example.library.jbel.entity.DemandeConge;

import java.util.List;

public interface DemandCongeServ {
    List<DemandeConge> getAllDemandesConge();
    DemandeConge getDemandeCongeById(Long id);
    DemandeConge saveDemandeConge(DemandeConge demandeConge);
    DemandeConge updateDemandeConge(Long id, DemandeConge nouvelleDemandeConge);
    void deleteDemandeConge(Long id);


}
