package be.tftic.spring.demo.api.controllers;


import be.tftic.spring.demo.api.model.dto.AffichageDTO;
import be.tftic.spring.demo.api.model.form.AffichageForm;
import be.tftic.spring.demo.bll.services.AffichageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/affichages")
public class AffichageController {

    private final AffichageService affichageService;

    @Autowired
    public AffichageController(AffichageService affichageService) {
        this.affichageService = affichageService;
    }

    @GetMapping
    public ResponseEntity<List<AffichageDTO>> getAllAffichages() {
        List<AffichageDTO> affichages = affichageService.getAllAffichages();
        return ResponseEntity.ok(affichages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffichageDTO> getAffichageById(@PathVariable Long id) {
        Optional<AffichageDTO> affichage = affichageService.getAffichageById(id);
        return affichage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AffichageDTO> createAffichage(@RequestBody AffichageDTO affichageForm) {
        AffichageDTO affichageDTO = affichageService.createAffichage(affichageForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(affichageDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffichageDTO> updateAffichage(@PathVariable Long id, @RequestBody AffichageForm affichageForm) {
        AffichageDTO updatedAffichage = affichageService.updateAffichage(id, affichageForm);
        return ResponseEntity.ok(updatedAffichage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffichage(@PathVariable Long id) {
        affichageService.deleteAffichageById(id);
        return ResponseEntity.noContent().build();
    }
}

