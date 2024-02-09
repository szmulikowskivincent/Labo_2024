package be.tftic.spring.demo.api.controllers;


import be.tftic.spring.demo.api.model.dto.ModePaiementDTO;
import be.tftic.spring.demo.bll.services.ModePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/modepaiements")
public class ModePaiementController {

    private final ModePaiementService modePaiementService;

    @Autowired
    public ModePaiementController(ModePaiementService modePaiementService) {
        this.modePaiementService = modePaiementService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModePaiementDTO> getModePaiementById(@PathVariable int id) {
        ModePaiementDTO modePaiementDTO = modePaiementService.getModePaiementById(id);
        if ( modePaiementDTO != null ) {
            return ResponseEntity.ok(modePaiementDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ModePaiementDTO>> getAllModePaiements() {
        List<ModePaiementDTO> modePaiements = modePaiementService.getAllModePaiements();
        return ResponseEntity.ok(modePaiements);
    }

    @PostMapping
    public ResponseEntity<ModePaiementDTO> createModePaiement(@Valid @RequestBody ModePaiementDTO modePaiementDTO) {
        ModePaiementDTO createdModePaiement = modePaiementService.createModePaiement(modePaiementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModePaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModePaiement(@PathVariable int id) {
        modePaiementService.deleteModePaiement(id);
        return ResponseEntity.noContent().build();
    }
}

