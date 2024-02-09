package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.dal.UserRepository;
import be.tftic.spring.demo.domain.entities.Galerie1;
import org.springframework.beans.factory.annotation.Autowired;
import be.tftic.spring.demo.dal.Galerie1Repository;
import org.springframework.stereotype.Service;
import be.tftic.spring.demo.bll.services.Galerie1Service;

import java.util.List;
import java.util.Optional;

@Service
public class Galerie1ServiceImpl implements Galerie1Service {

    @Autowired
    private Galerie1Repository galerieRepository;

    //TODO
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Galerie1> getAllGaleries() {
        return galerieRepository.findAll();
    }

    @Override
    public Optional<Galerie1> getGalerieById(Long id) {
        return galerieRepository.findById(id);
    }

    @Override
    public Galerie1 createGalerie(Galerie1 galerie) {
        galerie.setUser(userRepository.findById(1L).get());
        return galerieRepository.save(galerie);
    }

    @Override
    public Galerie1 updateGalerie(Long id, Galerie1 updatedGalerie) {
        if ( galerieRepository.existsById(id) ) {
            updatedGalerie.setIdGalerie(id);
            return galerieRepository.save(updatedGalerie);
        } else {

            return null;
        }
    }

    @Override
    public void deleteGalerie(Long id) {
        galerieRepository.deleteById(id);
    }
}

