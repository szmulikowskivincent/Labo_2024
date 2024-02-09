package be.tftic.spring.demo.api.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModePaiementDTO {

    private int idModePaiement;
    private String choixPaiement;

    public void setIdModePaiement(int idModePaiement) {
        this.idModePaiement = idModePaiement;
    }

    public void setChoixPaiement(String choixPaiement) {
        this.choixPaiement = choixPaiement;
    }
}

