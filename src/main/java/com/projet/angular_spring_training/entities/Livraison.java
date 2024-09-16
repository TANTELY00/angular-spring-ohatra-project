package com.projet.angular_spring_training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Livraison implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateLivraison;
    @OneToOne
    private Commande commandes;
    @ManyToOne
    private Livreur livreur;
    private boolean livrer = false;
}
