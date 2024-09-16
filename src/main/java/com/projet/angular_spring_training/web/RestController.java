package com.projet.angular_spring_training.web;

import com.projet.angular_spring_training.entities.*;
import com.projet.angular_spring_training.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private AdminRepository adminRepository;
    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;
    private LivraisonRepository livraisonRepository;
    private LivreurRepository livreurRepository;
    private ProduitRepository produitRepository;

    public RestController(AdminRepository adminRepository, ClientRepository clientRepository, CommandeRepository commandeRepository, LivraisonRepository livraisonRepository, LivreurRepository livreurRepository, ProduitRepository produitRepository) {
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
        this.livraisonRepository = livraisonRepository;
        this.livreurRepository = livreurRepository;
        this.produitRepository = produitRepository;
    }

    // GET ALL ADMIN
    @GetMapping(path = "/admin")
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }


    // GET ALL CLIENT
    @GetMapping(path = "/clients")
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    // GET ALL COMMAND
    @GetMapping(path = "/livreurs")
    public List<Livreur> getLivreur(){
        return livreurRepository.findAll();
    }

    // GET ALL PRODUCT
    @GetMapping(path = "/products")
    public List<Produit> getProduct(){
        return produitRepository.findAll();
    }

    // GET ALL COMMANDE
    @GetMapping(path = "/commands")
    public List<Commande> getCommande(){
        return commandeRepository.findAll();
    }

    // GET ALL LIVRAISON
    @GetMapping(path = "/livraisons")
    public List<Livraison> getAllLivraisons(){
        return livraisonRepository.findAll();
    }


}
