package com.projet.angular_spring_training.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter @ToString
public class ClientDTO {
    private String nom;
    private String prenoms;
    private String adresse;
    private String telephone;
    private String email;
    private String photos;
    private String region;
}
