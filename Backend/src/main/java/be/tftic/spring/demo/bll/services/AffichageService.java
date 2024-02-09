package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.api.model.dto.AffichageDTO;
import be.tftic.spring.demo.api.model.form.AffichageForm;

import java.util.List;
import java.util.Optional;

public interface AffichageService {
    List<AffichageDTO> getAllAffichages();
    Optional<AffichageDTO> getAffichageById(Long id);
    AffichageDTO createAffichage(AffichageDTO affichageDTO);
    void deleteAffichageById(Long id);
    AffichageDTO updateAffichage(Long id, AffichageForm affichageForm);
}


