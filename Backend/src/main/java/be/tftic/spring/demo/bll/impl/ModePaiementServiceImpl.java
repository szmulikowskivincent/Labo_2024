package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.api.model.dto.ModePaiementDTO;
import be.tftic.spring.demo.bll.services.ModePaiementService;
import be.tftic.spring.demo.dal.ModePaiementRepository;
import be.tftic.spring.demo.domain.entities.ModePaiement;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModePaiementServiceImpl implements ModePaiementService {

    private final ModePaiementRepository modePaiementRepository;

    @Autowired
    public ModePaiementServiceImpl(ModePaiementRepository modePaiementRepository) {
        this.modePaiementRepository = modePaiementRepository;
    }

    @Override
    public ModePaiementDTO getModePaiementById(int id) {
        Optional<ModePaiement> modePaiementOptional = modePaiementRepository.findById(id);
        return modePaiementOptional.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<ModePaiementDTO> getAllModePaiements() {
        List<ModePaiement> modePaiements = modePaiementRepository.findAll();
        return modePaiements.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ModePaiementDTO createModePaiement(ModePaiementDTO modePaiementDTO) {
        ModePaiement modePaiement = convertToEntity(modePaiementDTO);
        ModePaiement savedModePaiement = modePaiementRepository.save(modePaiement);
        return convertToDto(savedModePaiement);
    }

    @Override
    public void deleteModePaiement(int id) {
        modePaiementRepository.deleteById(id);
    }

    private ModePaiementDTO convertToDto(ModePaiement modePaiement) {
        ModePaiementDTO modePaiementDTO = new ModePaiementDTO();
        BeanUtils.copyProperties(modePaiement, modePaiementDTO);
        return modePaiementDTO;
    }

    private ModePaiement convertToEntity(ModePaiementDTO modePaiementDTO) {
        ModePaiement modePaiement = new ModePaiement();
        BeanUtils.copyProperties(modePaiementDTO, modePaiement);
        return modePaiement;
    }
}

