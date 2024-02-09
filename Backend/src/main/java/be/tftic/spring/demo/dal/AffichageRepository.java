package be.tftic.spring.demo.dal;


import be.tftic.spring.demo.domain.entities.Affichage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffichageRepository extends JpaRepository<Affichage, Long> {
    List<Affichage> findAllByPersonnelIdPersonnel(Long idPersonnel);
}



