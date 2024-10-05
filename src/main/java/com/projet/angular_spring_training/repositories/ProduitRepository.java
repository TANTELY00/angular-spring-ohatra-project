package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Produit findByCode(String code);
    Produit findByDesignation(String designation);

    List<Produit> findByCathegorieNomCategorie(String nomCathegorie);

}
