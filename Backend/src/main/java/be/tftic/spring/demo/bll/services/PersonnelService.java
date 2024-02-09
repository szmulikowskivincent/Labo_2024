package be.tftic.spring.demo.bll.services;

import be.tftic.spring.demo.api.model.dto.PersonnelDTO;
import be.tftic.spring.demo.domain.entities.Personnel;

import java.util.List;
import java.util.Optional;

public interface PersonnelService {

    List<PersonnelDTO> getAllPersonnel();

    Optional<PersonnelDTO> getPersonnelById(int id);

    PersonnelDTO createPersonnel(PersonnelDTO personnelDTO);

    void deletePersonnelById(int id);

    Object convertToDTO(Personnel personnel);
}

