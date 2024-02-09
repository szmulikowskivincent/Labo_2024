package be.tftic.spring.demo.api.model.form;


import lombok.Getter;

@Getter
public class AffichageForm {

    private Long idPersonnel;
    private Long idReservation;


    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

}

