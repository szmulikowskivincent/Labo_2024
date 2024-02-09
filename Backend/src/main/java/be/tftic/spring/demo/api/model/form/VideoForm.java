package be.tftic.spring.demo.api.model.form;


import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class VideoForm {

    @NotBlank(message = "L'URL de la vidéo ne peut pas être vide")
    private String videoUrl;

    @NotNull(message = "L'utilisateur ne peut pas être vide")
    private Long userId;
}
