package be.tftic.spring.demo.api.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PanierDTO {

    private int idPanier;
    private String nombreUser;
    private String description;

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

