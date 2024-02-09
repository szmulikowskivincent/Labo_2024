package be.tftic.spring.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "affichage")
public class Affichage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_personnel")
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    public Affichage() {
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Affichage{" +
                "id=" + id +
                ", personnel=" + personnel +
                ", reservation=" + reservation +
                '}';
    }
}



