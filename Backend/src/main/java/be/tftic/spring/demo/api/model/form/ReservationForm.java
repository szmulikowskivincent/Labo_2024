package be.tftic.spring.demo.api.model.form;


import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Getter
@Setter
public class ReservationForm {

    @NotNull
    private Date dateReservation;

    @Min(value = 1, message = "Veuillez sélectionner un mode de paiement")
    private int idModePaiement;

    @Min(value = 1, message = "Veuillez sélectionner un menu")
    private int idMenu;

    @Min(value = 1, message = "Veuillez sélectionner un utilisateur")
    private int idUser;
}

