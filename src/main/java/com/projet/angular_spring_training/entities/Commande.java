package com.projet.angular_spring_training.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class Commande implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCommande;
    private TypePayment typePayment;
    private String photosPayement;
    private int qteCommander;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Client client;
}
