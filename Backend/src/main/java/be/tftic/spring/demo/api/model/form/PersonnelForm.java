package be.tftic.spring.demo.api.model.form;


import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class PersonnelForm {

    @NotBlank(message = "Le nom du chauffeur ne peut pas être vide")
    private String nomChauffeur;
}

