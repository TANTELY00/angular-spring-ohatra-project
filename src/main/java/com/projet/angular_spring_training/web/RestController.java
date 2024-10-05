package com.projet.angular_spring_training.web;

import com.projet.angular_spring_training.dto.AdminDTO;
import com.projet.angular_spring_training.dto.ClientDTO;
import com.projet.angular_spring_training.dto.CommandeDTO;
import com.projet.angular_spring_training.dto.ProduitDTO;
import com.projet.angular_spring_training.entities.*;
import com.projet.angular_spring_training.repositories.*;
import com.projet.angular_spring_training.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@CrossOrigin("*")
public class RestController {
    private AdminRepository adminRepository;
    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;
    private LivraisonRepository livraisonRepository;
    private LivreurRepository livreurRepository;
    private ProduitRepository produitRepository;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CathegorieService cathegorieService;

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CathegorieRepositorie cathegorieRepositorie;

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
    @GetMapping(path = "/produit/{nomCathegorie}")
    public List<Produit> getProduct(@PathVariable String nomCathegorie){
        return produitRepository.findByCathegorieNomCategorie(nomCathegorie);
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


    // SAVE ADMIN
    @PostMapping(path = "/save/admin")
    public Admin saveAdmin(@RequestBody AdminDTO adminDTO){
        return  adminService.saveAdmin(adminDTO);
    }

    // SAVE CLIENT
//    @PostMapping(path = "/save/client")
//    public Client saveClient(@RequestBody ClientDTO clientDTO){
//        return clientService.saveClient(clientDTO);
//    }    @PostMapping(path = "/save/client")
    public Client saveClient(@RequestBody ClientDTO clientDTO){
        return clientService.saveClient(clientDTO);
    }

    // SAVE COMMANDE
    @PostMapping(path = "/save/commands")
    public Commande saveCommande(@RequestBody CommandeDTO commandeDTO){
        return commandeService.saveCommande(commandeDTO);
    }

    // SAVE CATHEGORIE
    @PostMapping(path = "/saveCathegorie")
    public Cathegorie saveCathegorie(@RequestBody Cathegorie cathegorie){
        return cathegorieService.saveCathegorie(cathegorie);
    }

    // SAVE PRODUCT
    @PostMapping(path = "/saveProduct")
    public Produit saveProduct(@RequestBody ProduitDTO produitDTO){
        return  produitService.saveProduit(produitDTO);
    }

    // GET CATEGORIES
    @GetMapping(path = "/cathegories")
    public List<Cathegorie> getAllCathegorie(){
        return cathegorieRepositorie.findAll();
    }

}
