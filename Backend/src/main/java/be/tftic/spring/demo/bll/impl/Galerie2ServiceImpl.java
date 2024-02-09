package be.tftic.spring.demo.bll.impl;

import be.tftic.spring.demo.bll.services.Galerie2Service;
import be.tftic.spring.demo.dal.Galerie2Repository;
import be.tftic.spring.demo.dal.UserRepository;
import be.tftic.spring.demo.domain.entities.Galerie2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Galerie2ServiceImpl implements Galerie2Service {

    private final Galerie2Repository galerie2Repository;

    //TODO
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public Galerie2ServiceImpl(Galerie2Repository galerie2Repository) {
        this.galerie2Repository = galerie2Repository;
    }

    @Override
    public List<Galerie2> getAllGaleries() {
        return galerie2Repository.findAll();
    }

    @Override
    public Optional<Galerie2> getGalerieById(Long id) {
        return galerie2Repository.findById(id);
    }

    @Override
    public Galerie2 createGalerie(Galerie2 galerie) {
        galerie.setUser(userRepository.findById(1L).get());
        return galerie2Repository.save(galerie);
    }

    @Override
    public Galerie2 updateGalerie(Long id, Galerie2 updatedGalerie) {
        Optional<Galerie2> existingGalerie = galerie2Repository.findById(id);
        if ( existingGalerie.isPresent() ) {
            updatedGalerie.setId(id);
            return galerie2Repository.save(updatedGalerie);
        } else {
            return null; // You may want to throw an exception here instead
        }
    }

    @Override
    public void deleteGalerie(Long id) {
        galerie2Repository.deleteById(id);
    }
}


