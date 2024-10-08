package com.projet.angular_spring_training.dto;

import com.projet.angular_spring_training.entities.Cathegorie;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class ProduitDTO {
    private String code;
    private String designation;
    private int quantite;
    private double prix;
    private String type;
    private String description;
    private String couleur;
    private String photos;
    private String pointure;
    private String nomCathegorie;
}
