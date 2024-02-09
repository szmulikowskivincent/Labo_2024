package be.tftic.spring.demo.api.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationDTO {
    private int idReservation;
    private Date dateReservation;
    private int idModePaiement;
    private int idMenu;
    private int idUser;
}

