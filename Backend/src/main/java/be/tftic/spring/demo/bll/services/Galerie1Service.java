package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.domain.entities.Galerie1;

import java.util.List;
import java.util.Optional;

public interface Galerie1Service {

    List<Galerie1> getAllGaleries();

    Optional<Galerie1> getGalerieById(Long id);

    Galerie1 createGalerie(Galerie1 galerie);

    Galerie1 updateGalerie(Long id, Galerie1 updatedGalerie);

    void deleteGalerie(Long id);
}

