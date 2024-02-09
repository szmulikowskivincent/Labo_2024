package be.tftic.spring.demo.api.model.dto;


import be.tftic.spring.demo.domain.enums.Categorie;
import lombok.Getter;

@Getter
public class MenuDTO {

    private int idMenu;
    private String nomMenu;
    private double prix;
    private Categorie catégorie;

    public MenuDTO() {
    }

    public MenuDTO(int idMenu, String nomMenu, double prix, Categorie catégorie) {
        this.idMenu = idMenu;
        this.nomMenu = nomMenu;
        this.prix = prix;
        this.catégorie = catégorie;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setNomMenu(String nomMenu) {
        this.nomMenu = nomMenu;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCatégorie(Categorie catégorie) {
        this.catégorie = catégorie;
    }
}
