package be.tftic.spring.demo.api.model.dto;

import lombok.Getter;

@Getter
public class Galerie2DTO {

    private Long idGalerie;
    private String titre;
    private String description;

    public Galerie2DTO() {
    }

    public Galerie2DTO(Long idGalerie, String titre, String description) {
        this.idGalerie = idGalerie;
        this.titre = titre;
        this.description = description;
    }

    public void setIdGalerie(Long idGalerie) {
        this.idGalerie = idGalerie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
