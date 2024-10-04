package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.dto.CommandeDTO;
import com.projet.angular_spring_training.entities.*;
import com.projet.angular_spring_training.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Service
@Transactional
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LivraisonRepository livraisonRepository;

    @Autowired
    private LivreurRepository livreurRepository;


    public Commande saveCommande(CommandeDTO commandeDTO){
        Produit produits = produitRepository.findByCode(commandeDTO.getCodeProduit());

        // creation de client
        Client client = Client.builder()
                .nom(commandeDTO.getNomClient())
                .prenoms(commandeDTO.getPrenoms())
                .adresse(commandeDTO.getAdresseClient())
                .email(commandeDTO.getEmail())
                .region(commandeDTO.getRegionClient())
                .telephone(commandeDTO.getTelephoneClient())
                .photos(commandeDTO.getPhotosPayement())
                .build();
        clientRepository.save(client);

        // creation du commande
        Commande commande = Commande.builder()
                .dateCommande(commandeDTO.getDateCommande())
                .typePayment((commandeDTO.getTypePayment()))
                .photosPayement(commandeDTO.getPhotosPayement())
                .qteCommander(commandeDTO.getQteCommander())
                .produit(produits)
                .client(client)
                .build();

        // creation de livraison
        LocalDate dateCommande = commande.getDateCommande();
        LocalDate nextDay = dateCommande;
        if (client.getRegion() != "Fianarantsoa"){
            nextDay = dateCommande.plusDays(2); // +2 le jour de la date courant
        } else if (client.getRegion() == "Fianarantsoa") {
            nextDay = dateCommande.plusDays(1); // +1 le jour de la date courant
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = nextDay.format(dateTimeFormatter);
        List<Livreur> livreursList = livreurRepository.findAll();
        List<Livreur> livreursDisponibles = new ArrayList<>();
        livreursList.forEach(livreur -> {
            if (livreur.isDisponibilite()){
                livreursDisponibles.add(livreur);
            }
        });
        if(!livreursDisponibles.isEmpty()){
            int compteur = livreursDisponibles.size();
            Livraison livraison = Livraison.builder()
                    .dateLivraison(date)
                    .commandes(commande)
                    .livreur(livreursDisponibles.get(new Random().nextInt(compteur)))
                    .livrer(false)
                    .build();
            livraisonRepository.save(livraison);
        }else {
            int compteur = livreursList.size();
            Livraison livraison = Livraison.builder()
                    .dateLivraison(date)
                    .commandes(commande)
                    .livreur(livreursList.get(new Random().nextInt(compteur)))
                    .livrer(false)
                    .build();
            livraisonRepository.save(livraison);
        }
        if (commande.getQteCommander() > (produits).getQuantite()){
            return null; // peut etre exception
        }
        return commandeRepository.save(commande);

    }
}
