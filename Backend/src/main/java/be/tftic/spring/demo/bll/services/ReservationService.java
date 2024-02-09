package be.tftic.spring.demo.bll.services;


import be.tftic.spring.demo.api.model.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    ReservationDTO getReservationById(int id);

    List<ReservationDTO> getAllReservations();

    ReservationDTO createReservation(ReservationDTO reservationDTO);

    void deleteReservation(int id);
}

