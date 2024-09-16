package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
