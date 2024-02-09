package be.tftic.spring.demo.api.controllers;


import be.tftic.spring.demo.api.model.dto.PanierDTO;
import be.tftic.spring.demo.bll.services.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    private final PanierService panierService;

    @Autowired
    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanierDTO> getPanierById(@PathVariable int id) {
        PanierDTO panierDTO = panierService.getPanierById(id);
        if (panierDTO != null) {
            return ResponseEntity.ok(panierDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PanierDTO>> getAllPaniers() {
        List<PanierDTO> paniers = panierService.getAllPaniers();
        return ResponseEntity.ok(paniers);
    }

    @PostMapping
    public ResponseEntity<PanierDTO> createPanier(@Valid @RequestBody PanierDTO panierDTO) {
        PanierDTO createdPanier = panierService.createPanier(panierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPanier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanier(@PathVariable int id) {
        panierService.deletePanier(id);
        return ResponseEntity.noContent().build();
    }
}
