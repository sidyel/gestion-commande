package com.vente1.repository;

import com.vente1.entite.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande,Long> {

    @Query(value = "SELECT produit_id, SUM(quantite) as totalQuantite " +
            "FROM detail_commande " +
            "GROUP BY produit_id " +
            "ORDER BY totalQuantite DESC " +
            "LIMIT 1", nativeQuery = true)
    Long findMostSoldProductId();
}
