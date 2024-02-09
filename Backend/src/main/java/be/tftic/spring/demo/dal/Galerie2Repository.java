package be.tftic.spring.demo.dal;


import be.tftic.spring.demo.domain.entities.Galerie2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Galerie2Repository extends JpaRepository<Galerie2, Long> {
}
