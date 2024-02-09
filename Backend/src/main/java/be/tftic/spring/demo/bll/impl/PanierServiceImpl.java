package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.api.model.dto.PanierDTO;
import be.tftic.spring.demo.bll.services.PanierService;
import be.tftic.spring.demo.dal.PanierRepository;
import be.tftic.spring.demo.domain.entities.Panier;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanierServiceImpl implements PanierService {

    private final PanierRepository panierRepository;

    @Autowired
    public PanierServiceImpl(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    @Override
    public PanierDTO getPanierById(int id) {
        Optional<Panier> panierOptional = panierRepository.findById(id);
        return panierOptional.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<PanierDTO> getAllPaniers() {
        List<Panier> paniers = panierRepository.findAll();
        return paniers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PanierDTO createPanier(PanierDTO panierDTO) {
        Panier panier = convertToEntity(panierDTO);
        Panier savedPanier = panierRepository.save(panier);
        return convertToDto(savedPanier);
    }

    @Override
    public void deletePanier(int id) {
        panierRepository.deleteById(id);
    }

    private PanierDTO convertToDto(Panier panier) {
        PanierDTO panierDTO = new PanierDTO();
        BeanUtils.copyProperties(panier, panierDTO);
        return panierDTO;
    }

    private Panier convertToEntity(PanierDTO panierDTO) {
        Panier panier = new Panier();
        BeanUtils.copyProperties(panierDTO, panier);
        return panier;
    }
}


