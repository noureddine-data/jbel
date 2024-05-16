package org.example.library.jbel.service.impl;

import org.example.library.jbel.entity.DemandeAugmentation;

import java.util.List;

public interface DemandAugServ {
    List<DemandeAugmentation> getAllDemandesAug();

    DemandeAugmentation getDemandeAugById(Long id);

    DemandeAugmentation saveDemandeAug(DemandeAugmentation demandeAugmentation);
}
