package be.tftic.spring.demo.api.controllers;

import be.tftic.spring.demo.domain.entities.Galerie2;
import be.tftic.spring.demo.bll.services.Galerie2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/galerie2")
public class Galerie2Controller {

    @Autowired
    private Galerie2Service galerieService;

    @GetMapping
    public List<Galerie2> getAllGaleries() {
        return galerieService.getAllGaleries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galerie2> getGalerieById(@PathVariable Long id) {
        Optional<Galerie2> galerie = galerieService.getGalerieById(id);
        return galerie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Galerie2> createGalerie(@RequestBody Galerie2 galerie) {
        Galerie2 createdGalerie = galerieService.createGalerie(galerie);
        return new ResponseEntity<>(createdGalerie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galerie2> updateGalerie(@PathVariable Long id, @RequestBody Galerie2 updatedGalerie) {
        Galerie2 galerie = galerieService.updateGalerie(id, updatedGalerie);
        if (galerie != null) {
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
