package be.tftic.spring.demo.bll.services;


import be.tftic.spring.demo.api.model.dto.ModePaiementDTO;

import java.util.List;

public interface ModePaiementService {
    ModePaiementDTO getModePaiementById(int id);
    List<ModePaiementDTO> getAllModePaiements();
    ModePaiementDTO createModePaiement(ModePaiementDTO modePaiementDTO);
    void deleteModePaiement(int id);
}

