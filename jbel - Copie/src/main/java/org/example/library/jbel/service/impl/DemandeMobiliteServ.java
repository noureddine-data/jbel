package org.example.library.jbel.service.impl;


import org.example.library.jbel.entity.DemandeMobilite;

import java.util.List;

public interface DemandeMobiliteServ {
    List<DemandeMobilite> getAllDemandesMobilite();
    DemandeMobilite getDemandeMobiliteById(Long id);
    DemandeMobilite saveDemandeMobilte(DemandeMobilite demandeMobilite);
    DemandeMobilite updateDemandeMobilite(Long id, DemandeMobilite nouvelleDemandeMobilte);
    void deleteDemandeMobilite(Long id);


}
