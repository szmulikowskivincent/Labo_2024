package be.tftic.spring.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personnel")
    private Long idPersonnel;

    @Column(name = "nom_chauffeur", nullable = false)
    private String nomChauffeur;

    public Personnel() {
    }

    public Personnel(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "idPersonnel=" + idPersonnel +
                ", nomChauffeur='" + nomChauffeur + '\'' +
                '}';
    }

    public void setIdPersonnel(int idPersonnel) {
    }
}


