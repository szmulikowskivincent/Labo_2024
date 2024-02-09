package be.tftic.spring.demo.bll.impl;


import be.tftic.spring.demo.api.model.dto.ReservationDTO;
import be.tftic.spring.demo.bll.services.ReservationService;
import be.tftic.spring.demo.dal.ReservationRepository;
import be.tftic.spring.demo.domain.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationDTO getReservationById(int id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(this::mapToReservationDTO).orElse(null);
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(this::mapToReservationDTO).collect(Collectors.toList());
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = mapToReservation(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return mapToReservationDTO(savedReservation);
    }

    @Override
    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO mapToReservationDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setIdReservation(reservation.getIdReservation());
        reservationDTO.setDateReservation(reservation.getDateReservation());
        reservationDTO.setIdModePaiement(reservation.getIdModePaiement());
        reservationDTO.setIdMenu(reservation.getIdMenu());
        reservationDTO.setIdUser(reservation.getIdUser());
        return reservationDTO;
    }

    private Reservation mapToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setIdReservation(reservationDTO.getIdReservation());
        reservation.setDateReservation(reservationDTO.getDateReservation());
        reservation.setIdModePaiement(reservationDTO.getIdModePaiement());
        reservation.setIdMenu(reservationDTO.getIdMenu());
        reservation.setIdUser(reservationDTO.getIdUser());
        return reservation;
    }
}
