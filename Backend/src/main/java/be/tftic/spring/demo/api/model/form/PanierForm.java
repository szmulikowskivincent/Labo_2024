package be.tftic.spring.demo.api.model.form;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierForm {

    @NotBlank(message = "Le nombre d'utilisateurs ne peut pas être vide")
    private String nombreUser;

    @NotBlank(message = "La description ne peut pas être vide")
    private String description;
}

