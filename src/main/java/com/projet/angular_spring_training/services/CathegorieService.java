package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.entities.Cathegorie;
import com.projet.angular_spring_training.repositories.CathegorieRepositorie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CathegorieService {
    @Autowired
    private CathegorieRepositorie cathegorieRepositorie;
    public Cathegorie saveCathegorie(Cathegorie cathegorie){
       Cathegorie cathegorie1 = Cathegorie.builder()
               .nomCategorie(cathegorie.getNomCategorie())
               .build();
       return cathegorieRepositorie.save(cathegorie1);
    }
}
