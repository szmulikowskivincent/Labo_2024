package be.tftic.spring.demo.api.controllers;


import be.tftic.spring.demo.bll.services.Galerie1Service;
import be.tftic.spring.demo.domain.entities.Galerie1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/galerie1")
public class Galerie1Controller {

    @Autowired
    private Galerie1Service galerieService;

    @GetMapping
    public List<Galerie1> getAllGaleries() {
        return galerieService.getAllGaleries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galerie1> getGalerieById(@PathVariable Long id) {
        Optional<Galerie1> galerie = galerieService.getGalerieById(id);
        return galerie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Galerie1> createGalerie(@RequestBody Galerie1 galerie) {
        Galerie1 createdGalerie = galerieService.createGalerie(galerie);
        return new ResponseEntity<>(createdGalerie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galerie1> updateGalerie(@PathVariable Long id, @RequestBody Galerie1 updatedGalerie) {
        Galerie1 galerie = galerieService.updateGalerie(id, updatedGalerie);
        if ( galerie != null ) {
            return new ResponseEntity<>(galerie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGalerie(@PathVariable Long id) {
        galerieService.deleteGalerie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


