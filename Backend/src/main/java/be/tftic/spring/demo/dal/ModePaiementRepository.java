package be.tftic.spring.demo.dal;


import be.tftic.spring.demo.domain.entities.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModePaiementRepository extends JpaRepository<ModePaiement, Integer> {
    ModePaiement findByChoixPaiement(String choixPaiement);
}


