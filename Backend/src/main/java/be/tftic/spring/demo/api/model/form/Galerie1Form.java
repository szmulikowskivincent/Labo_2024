package be.tftic.spring.demo.api.model.form;


import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class Galerie1Form {

    @NotBlank(message = "Le commentaire ne peut pas être vide")
    private String commentaire;

    private Double nombreLike;

    @NotBlank(message = "La description ne peut pas être vide")
    private String description;

    @NotNull(message = "L'utilisateur ne peut pas être vide")
    private Long idUser;
}

