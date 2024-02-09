package be.tftic.spring.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private int idReservation;

    @Column(name = "date_reservation", nullable = false)
    private Date dateReservation;

    @Column(name = "id_mode_paiement", nullable = false)
    private int idModePaiement;

    @Column(name = "id_menu", nullable = false)
    private int idMenu;

    @Column(name = "id_user", nullable = false)
    private int idUser;

    @ManyToOne
    @JoinColumn(name = "id_mode_paiement", referencedColumnName = "id_mode_paiement", insertable = false, updatable = false)
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
    private Menu menu;

}



