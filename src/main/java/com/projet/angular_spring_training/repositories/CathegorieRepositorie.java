package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Cathegorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CathegorieRepositorie extends JpaRepository<Cathegorie,Long> {
    Cathegorie findByNomCategorie(String nomCathegorie);
}
