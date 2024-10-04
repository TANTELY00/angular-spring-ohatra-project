package com.projet.angular_spring_training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class Cathegorie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomCategorie;
    private String description;
    private String image;
}
