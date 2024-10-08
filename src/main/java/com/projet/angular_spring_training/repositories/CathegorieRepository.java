package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Cathegorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CathegorieRepository extends JpaRepository<Cathegorie,Long> {
    Cathegorie findByNomCategorie(String nomCategorie);
    List<Cathegorie> findAll();
}
