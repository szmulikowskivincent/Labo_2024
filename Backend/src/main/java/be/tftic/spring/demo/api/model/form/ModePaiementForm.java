package be.tftic.spring.demo.api.model.form;


import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class ModePaiementForm {

    @NotBlank(message = "Le choix de paiement ne peut pas être vide")
    private String choixPaiement;

    public void setChoixPaiement(String choixPaiement) {
        this.choixPaiement = choixPaiement;
    }
}

