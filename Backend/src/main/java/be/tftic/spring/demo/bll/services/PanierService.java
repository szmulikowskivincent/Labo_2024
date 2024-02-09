package be.tftic.spring.demo.bll.services;


import be.tftic.spring.demo.api.model.dto.PanierDTO;

import java.util.List;

public interface PanierService {
    PanierDTO getPanierById(int id);
    List<PanierDTO> getAllPaniers();
    PanierDTO createPanier(PanierDTO panierDTO);
    void deletePanier(int id);
}

