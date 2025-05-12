package com.produit1.repository;


import com.produit1.entite.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
