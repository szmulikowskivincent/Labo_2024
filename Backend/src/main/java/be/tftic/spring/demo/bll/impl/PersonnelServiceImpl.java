package be.tftic.spring.demo.bll.impl;

import be.tftic.spring.demo.api.model.dto.PersonnelDTO;
import be.tftic.spring.demo.bll.services.PersonnelService;
import be.tftic.spring.demo.dal.PersonnelRepository;
import be.tftic.spring.demo.domain.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelRepository personnelRepository;

    @Autowired
    public PersonnelServiceImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public List<PersonnelDTO> getAllPersonnel() {
        List<Personnel> personnelList = personnelRepository.findAll();
        return personnelList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonnelDTO> getPersonnelById(int id) {
        Optional<Personnel> personnel = personnelRepository.findById(id);
        return personnel.map(this::convertToDTO);
    }

    @Override
    public PersonnelDTO createPersonnel(PersonnelDTO personnelDTO) {
        Personnel personnel = convertToEntity(personnelDTO);
        Personnel savedPersonnel = personnelRepository.save(personnel);
        return convertToDTO(savedPersonnel);
    }

    @Override
    public void deletePersonnelById(int id) {
        personnelRepository.deleteById(id);
    }

    public PersonnelDTO convertToDTO(Personnel personnel) {
        PersonnelDTO personnelDTO = new PersonnelDTO();
        personnelDTO.setIdPersonnel(personnel.getIdPersonnel());
        personnelDTO.setNomChauffeur(personnel.getNomChauffeur());
        return personnelDTO;
    }

    private Personnel convertToEntity(PersonnelDTO personnelDTO) {
        Personnel personnel = new Personnel();
        personnel.setIdPersonnel(personnelDTO.getIdPersonnel());
        personnel.setNomChauffeur(personnelDTO.getNomChauffeur());
        return personnel;
    }
}

