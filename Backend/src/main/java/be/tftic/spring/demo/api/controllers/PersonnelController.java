package be.tftic.spring.demo.api.controllers;

import be.tftic.spring.demo.api.model.dto.PersonnelDTO;
import be.tftic.spring.demo.bll.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/personnels")
public class PersonnelController {

    private final PersonnelService personnelService;

    @Autowired
    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping
    public ResponseEntity<List<PersonnelDTO>> getAllPersonnel() {
        List<PersonnelDTO> personnelList = personnelService.getAllPersonnel();
        return new ResponseEntity<>(personnelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonnelDTO> getPersonnelById(@PathVariable int id) {
        Optional<PersonnelDTO> personnelDTO = personnelService.getPersonnelById(id);
        return personnelDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PersonnelDTO> createPersonnel(@RequestBody PersonnelDTO personnelDTO) {
        PersonnelDTO createdPersonnel = personnelService.createPersonnel(personnelDTO);
        return new ResponseEntity<>(createdPersonnel, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonnelById(@PathVariable int id) {
        personnelService.deletePersonnelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

