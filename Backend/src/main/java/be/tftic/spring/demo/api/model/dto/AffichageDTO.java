package be.tftic.spring.demo.api.model.dto;

import be.tftic.spring.demo.domain.entities.Affichage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AffichageDTO {

    private Long id;
    private Long idPersonnel;
    private Long idReservation;

    public AffichageDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public AffichageDTO(Long id, Long idPersonnel, Long idReservation) {
        this.id = id;
        this.idPersonnel = idPersonnel;
        this.idReservation = idReservation;
    }

    public static AffichageDTO fromEntity(Affichage affichage) {
        AffichageDTO affichageDTO = new AffichageDTO();
        affichageDTO.setId(affichage.getId());
        // Mapping de l'id du personnel
        if (affichage.getPersonnel() != null) {
            affichageDTO.setIdPersonnel(affichage.getPersonnel().getIdPersonnel());
        }
        // Mapping de l'id de la réservation
        if (affichage.getReservation() != null) {
            affichageDTO.setIdReservation(affichage.getReservation().getIdReservation());
        }
        return affichageDTO;
    }

    private void setIdReservation(int idReservation) {
    }
}


