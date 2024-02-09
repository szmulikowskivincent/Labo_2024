package be.tftic.spring.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_panier")
    private int idPanier;

    @Column(name = "nombre_user", nullable = false)
    private String nombreUser;

    @Column(name = "description", nullable = false)
    private String description;

    public Panier() {
    }

    public Panier(String nombreUser, String description) {
        this.nombreUser = nombreUser;
        this.description = description;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Panier{" +
                "idPanier=" + idPanier +
                ", nombreUser='" + nombreUser + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

