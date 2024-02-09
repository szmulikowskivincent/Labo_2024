package be.tftic.spring.demo.api.model.form;


import be.tftic.spring.demo.domain.enums.Categorie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuForm {

    @NotNull
    private Categorie categorie;

    @NotBlank(message = "Le nom du menu ne peut pas être vide")
    private String nomMenu;

    @NotNull(message = "Le prix ne peut pas être vide")
    private Double prix;
}
