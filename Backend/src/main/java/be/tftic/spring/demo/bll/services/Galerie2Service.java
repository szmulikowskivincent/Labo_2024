package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.domain.entities.Galerie2;

import java.util.List;
import java.util.Optional;

public interface Galerie2Service {

    List<Galerie2> getAllGaleries();

    Optional<Galerie2> getGalerieById(Long id);

    Galerie2 createGalerie(Galerie2 galerie);

    Galerie2 updateGalerie(Long id, Galerie2 updatedGalerie);

    void deleteGalerie(Long id);
}