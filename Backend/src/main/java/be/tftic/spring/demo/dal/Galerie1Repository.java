package be.tftic.spring.demo.dal;


import be.tftic.spring.demo.domain.entities.Galerie1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Galerie1Repository extends JpaRepository<Galerie1, Long> {
}


