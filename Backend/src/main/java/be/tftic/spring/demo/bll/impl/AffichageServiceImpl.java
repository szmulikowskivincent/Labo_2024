package be.tftic.spring.demo.bll.impl;

import be.tftic.spring.demo.api.model.dto.AffichageDTO;
import be.tftic.spring.demo.api.model.form.AffichageForm;
import be.tftic.spring.demo.bll.services.AffichageService;
import be.tftic.spring.demo.dal.AffichageRepository;
import be.tftic.spring.demo.domain.entities.Affichage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AffichageServiceImpl implements AffichageService {

    private final AffichageRepository affichageRepository;

    public AffichageServiceImpl(AffichageRepository affichageRepository) {
        this.affichageRepository = affichageRepository;
    }

    @Override
    public List<AffichageDTO> getAllAffichages() {
        return affichageRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AffichageDTO> getAffichageById(Long id) {
        return affichageRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public AffichageDTO createAffichage(AffichageDTO affichageDTO) {
        Affichage affichage = convertToEntity(affichageDTO);
        Affichage savedAffichage = affichageRepository.save(affichage);
        return convertToDTO(savedAffichage);
    }

    @Override
    public void deleteAffichageById(Long id) {
        affichageRepository.deleteById(id);
    }

    @Override
    public AffichageDTO updateAffichage(Long id, AffichageForm affichageForm) {
        return null;
    }

    private AffichageDTO convertToDTO(Affichage affichage) {
        AffichageDTO affichageDTO = new AffichageDTO();
        affichageDTO.setId(affichage.getId());
        return affichageDTO;
    }

    private Affichage convertToEntity(AffichageDTO affichageDTO) {
        Affichage affichage = new Affichage();
        affichage.setId(affichageDTO.getId());
        return affichage;
    }
}


