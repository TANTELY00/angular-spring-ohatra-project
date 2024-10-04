package com.projet.angular_spring_training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Produit implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String designation;
    private int quantite;
    private double prix;
    private String type;
    private String description;
    private String couleur;
    private String photos;
    @ManyToOne
    private Cathegorie cathegorie;
}
