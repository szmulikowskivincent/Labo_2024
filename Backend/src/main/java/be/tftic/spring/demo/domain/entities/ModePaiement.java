package be.tftic.spring.demo.domain.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "mode_paiement")
public class ModePaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mode_paiement")
    private int idModePaiement;

    @Column(name = "choix_paiement", nullable = false, length = 50)
    private String choixPaiement;

    public ModePaiement() {
    }


    public ModePaiement(String choixPaiement) {
        this.choixPaiement = choixPaiement;
    }

    public void setIdModePaiement(int idModePaiement) {
        this.idModePaiement = idModePaiement;
    }

    public void setChoixPaiement(String choixPaiement) {
        this.choixPaiement = choixPaiement;
    }
}

