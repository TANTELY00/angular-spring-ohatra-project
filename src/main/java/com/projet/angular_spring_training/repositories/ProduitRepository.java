package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
