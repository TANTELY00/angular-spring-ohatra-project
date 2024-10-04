package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.dto.ProduitDTO;
import com.projet.angular_spring_training.entities.Cathegorie;
import com.projet.angular_spring_training.entities.Produit;
import com.projet.angular_spring_training.repositories.CathegorieRepositorie;
import com.projet.angular_spring_training.repositories.ProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CathegorieRepositorie cathegorieRepositorie;
    public Produit saveProduit(ProduitDTO produitDTO){
        Random random = new Random();
        Cathegorie cathegorie = cathegorieRepositorie.findByNomCategorie(produitDTO.getNomCathegorie());

        Produit produit1 = Produit.builder()
                .code(UUID.randomUUID().toString())
                .designation(produitDTO.getDesignation())
                .quantite(produitDTO.getQuantite())
                .prix(produitDTO.getPrix())
                .type(produitDTO.getType())
                .description(produitDTO.getDescription())
                .couleur(produitDTO.getCouleur())
                .photos(produitDTO.getPhotos())
                .cathegorie(cathegorie)
                .build();
        return produitRepository.save(produit1);
    }
}
