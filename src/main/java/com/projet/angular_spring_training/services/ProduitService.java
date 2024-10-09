package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.dto.ProduitDTO;
import com.projet.angular_spring_training.entities.Cathegorie;
import com.projet.angular_spring_training.entities.Produit;
import com.projet.angular_spring_training.repositories.CathegorieRepository;
import com.projet.angular_spring_training.repositories.ProduitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CathegorieRepository cathegorieRepositorie;
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
                .pointure(produitDTO.getPointure())
                .cathegorie(cathegorie)
                .build();
        return produitRepository.save(produit1);
    }

    public List<Produit> getProductByQte( ){
        List<Produit> produitQTE = new ArrayList<>();
        List<Produit> produitList =  produitRepository.findAll();
        produitList.forEach(produit -> {
            if (produit.getQuantite() <= 10){
                produitQTE.add(produit);
            }
        });
        return  produitQTE;
    }
}
