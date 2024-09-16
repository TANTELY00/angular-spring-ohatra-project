package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {
}
