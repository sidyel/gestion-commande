package com.paiement1.repository;


import com.paiement1.entite.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    // Custom queries if necessary
    @Query("SELECT SUM(d.montant) FROM Paiement d")
    Double getTotalMontantVentes();
}
