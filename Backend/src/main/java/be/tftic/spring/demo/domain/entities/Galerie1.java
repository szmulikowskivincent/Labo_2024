package be.tftic.spring.demo.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "GALERIE1")
public class Galerie1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GALERIE")
    private Long idGalerie;

    @Column(length = 125)
    private String commentaire;

    @Column(name = "NOMBRE_LIKE")
    private Double nombreLike;

    @Column(length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;

    public Galerie1() {
    }

    public Galerie1(String commentaire, Double nombreLike, String description, User user) {
        this.commentaire = commentaire;
        this.nombreLike = nombreLike;
        this.description = description;
        this.user = user;
    }

    public void setIdGalerie(Long idGalerie) {
        this.idGalerie = idGalerie;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNombreLike(Double nombreLike) {
        this.nombreLike = nombreLike;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

