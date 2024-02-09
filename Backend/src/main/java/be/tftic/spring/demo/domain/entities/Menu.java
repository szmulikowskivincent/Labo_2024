package be.tftic.spring.demo.domain.entities;

import be.tftic.spring.demo.domain.enums.Categorie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menu")
public class Menu {

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie", nullable = false)
    private Categorie catégorie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private int idMenu;

    @Column(name = "nom_menu", nullable = false, length = 25)
    private String nomMenu;

    @Column(name = "prix", nullable = false)
    private double prix;

    public Menu() {
    }

    public Menu(String nomMenu, double prix, Categorie catégorie) {
        this.nomMenu = nomMenu;
        this.prix = prix;
        this.catégorie = catégorie;
    }

}


