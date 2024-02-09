package be.tftic.spring.demo.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnelDTO {

    private int idPersonnel;
    private String nomChauffeur;

    public PersonnelDTO() {
    }

    public PersonnelDTO(int idPersonnel, String nomChauffeur) {
        this.idPersonnel = idPersonnel;
        this.nomChauffeur = nomChauffeur;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    @Override
    public String toString() {
        return "PersonnelDTO{" +
                "idPersonnel=" + idPersonnel +
                ", nomChauffeur='" + nomChauffeur + '\'' +
                '}';
    }

    public void setIdPersonnel(Long idPersonnel) {
    }
}


