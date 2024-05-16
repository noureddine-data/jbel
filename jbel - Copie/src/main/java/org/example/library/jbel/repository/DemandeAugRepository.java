package org.example.library.jbel.repository;

import org.example.library.jbel.entity.DemandeAugmentation;
import org.example.library.jbel.entity.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeAugRepository extends JpaRepository<DemandeAugmentation,Long> {

}
