package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Commande;
import com.projet.angular_spring_training.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison,Long> {


}
