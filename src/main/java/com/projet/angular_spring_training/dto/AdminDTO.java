package com.projet.angular_spring_training.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder @ToString
public class AdminDTO {
    private String nom;
    private String prenoms;
    private String adresse;
    private String email;
    private String telephone;
    private String role;
    private String mdp;
    private String photos;
}
