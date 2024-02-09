package be.tftic.spring.demo.domain.entities;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "planning")
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planning")
    private int idPlanning;

    @Column(name = "date_prestation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePrestation;


    public Planning() {
    }

    public Planning(Date datePrestation) {
        this.datePrestation = datePrestation;
    }


    public void setIdPlanning(int idPlanning) {
        this.idPlanning = idPlanning;
    }

    public void setDatePrestation(Date datePrestation) {
        this.datePrestation = datePrestation;
    }


    @Override
    public String toString() {
        return "Planning{" +
                "idPlanning=" + idPlanning +
                ", datePrestation=" + datePrestation +
                '}';
    }
}

