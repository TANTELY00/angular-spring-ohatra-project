package com.projet.angular_spring_training.dto;

import com.projet.angular_spring_training.entities.Client;
import com.projet.angular_spring_training.entities.Produit;
import com.projet.angular_spring_training.entities.TypePayment;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommandeDTO {
    // command
    private LocalDate dateCommande;
    private int qteCommander;
    private TypePayment typePayment;
    private String photosPayement;

    // product
    private String codeProduit;

    // clients
    private String nomClient;
    private String prenoms;
    private String telephoneClient;
    private String adresseClient;
    private String regionClient;
    private String photos;
    private String email;

}
