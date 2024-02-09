package be.tftic.spring.demo.dal;

import be.tftic.spring.demo.domain.entities.Menu;
import be.tftic.spring.demo.domain.enums.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByCatégorie(Categorie catégorie);
}