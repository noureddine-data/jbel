package org.example.library.jbel.service.impl;

import org.example.library.jbel.entity.DemandeSortie;

import java.util.List;

public interface DemandeSortieServ {
    List<DemandeSortie> getAllDemandesSortie();
    DemandeSortie getDemandeSortieById(Long id);

    List<DemandeSortie> saveDemandeSortie();

    DemandeSortie saveDemandeSortie(DemandeSortie demandeSortie);
    DemandeSortie updateDemandeSortie(Long id, DemandeSortie nouvelleDemandeSortie);
    void deleteDemandeSortie(Long id);


}
