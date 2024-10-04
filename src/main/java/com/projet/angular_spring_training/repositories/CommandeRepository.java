package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Commande;
import com.projet.angular_spring_training.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
