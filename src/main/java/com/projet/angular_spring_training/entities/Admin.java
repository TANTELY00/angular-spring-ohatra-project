package com.projet.angular_spring_training.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString @Builder @Getter @Setter
public class Admin implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenoms;
    private String adresse;
    private String email;
    private String telephone;
    private String role;
    private String mdp;
    private String photos;
}
