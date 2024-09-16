package com.projet.angular_spring_training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Livreur implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenoms;
    private String adresse;
    private String telephone;
    private String photos;
    private String email;
    private boolean disponibilite = true;
}
