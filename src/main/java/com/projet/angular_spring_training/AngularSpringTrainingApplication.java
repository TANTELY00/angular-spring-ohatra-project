package com.projet.angular_spring_training;

import com.projet.angular_spring_training.entities.*;
import com.projet.angular_spring_training.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AngularSpringTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringTrainingApplication.class, args);
	}

	// TESTE D'INITIALISATION
	@Bean
	CommandLineRunner commandLineRunner (AdminRepository adminRepository,
										 ProduitRepository produitRepository,
										 ClientRepository clientRepository,
										 CommandeRepository commandeRepository,
										 LivraisonRepository livraisonRepository,
										 LivreurRepository livreurRepository,
										 CathegorieRepository cathegorieRepositorie

	){
		return args -> {
			Random random = new Random();
			// create two admins
			adminRepository.save(Admin.builder()
							.nom("RAVOSON")
							.prenoms("Tantelinirina")
							.role("Admin")
							.email("tantelyravoson2019@gmail.com")
							.adresse("Tanamba")
							.mdp("rasoa00")
							.photos("tantely.png")
							.telephone("0346145497").build());
			adminRepository.save(Admin.builder()
					.nom("RASOA")
					.prenoms("tANTELY")
					.role("user")
					.email("tantely@gmail.com")
					.adresse("TanambaO")
					.mdp("rasoa00")
					.photos("tantely.png")
					.telephone("0346145497").build());

			// create categorie
			Stream.of("Chaussures" ,"T-shirtt" ,"Veste" ,"Pantalon").forEach(name->{
				cathegorieRepositorie.save(Cathegorie.builder()
								.nomCategorie(name)
								.image(UUID.randomUUID().toString()+".png")
								.description(UUID.randomUUID().toString())
						.build());
			});

			List<Cathegorie> cathegories = cathegorieRepositorie.findAll();
			int indexCathegorie = cathegories.size();

			// create two products
			produitRepository.save(Produit.builder()
							.code("CHR")
							.designation("chaussure")
							.prix(20000)
							.quantite(10)
							.photos("chaussure.png")
							.prix(20000)
							.couleur("gris")
							.description("arrivage")
							.type("chaussure")
							.pointure("42")
							.cathegorie(cathegories.get(random.nextInt(indexCathegorie)))
					.build());
			produitRepository.save(Produit.builder()
					.code("cs")
					.designation("chemise")
					.prix(20000)
					.quantite(9)
					.photos("chemise.png")
					.prix(20000)
					.couleur("noire")
					.description("arrivage mlai")
					.type("talon")
					.pointure("L")
					.cathegorie(cathegories.get(random.nextInt(indexCathegorie)))
					.build());

			// create two clients
			clientRepository.save(Client.builder()
							.nom("rasoa")
							.prenoms("razafy")
							.adresse("Tanambao")
							.telephone("0346146497")
							.photos("rasoa.png")
							.region("Fianarantsoa")
							.email(UUID.randomUUID().toString()+"gmail.com")
					.build());
			clientRepository.save(Client.builder()
					.nom("rabe")
					.prenoms("razafy")
					.adresse("Mahamasina")
					.telephone("0346146497")
					.photos("rasoa.png")
					.region("Antananarivo")
					.email(UUID.randomUUID().toString()+"gmail.com")
					.build());

			// create new command foreach clients
			TypePayment[] type = TypePayment.values();
			List<Produit> produits = produitRepository.findAll();
			int index = produits.size();

			clientRepository.findAll().forEach(client -> {
						for (int i=0 ; i < produits.size() ; i++ ){
							int longueur = random.nextInt(type.length);
							commandeRepository.save(Commande.builder()
											.dateCommande(LocalDate.now())
											.typePayment(type[longueur])
											.produit(produits.get(random.nextInt(index)))
											.photosPayement("payement.pdf")
											.client(client)
									.build());
						}
					}
			);

			// creation du nouveau livreur
			livreurRepository.save(Livreur.builder()
					.nom("tahina")
					.prenoms("tanjona")
					.adresse("ambatomena")
					.telephone("0345454555")
					.photos("tahina.png")
					.email("tahina@gmail.com")
					.disponibilite(false)
					.build());
			livreurRepository.save(Livreur.builder()
					.nom("james")
					.prenoms("tanjaka")
					.adresse("ambatomena")
					.telephone("0345454555")
					.photos("tahina.png")
					.email("tahina@gmail.com")
					.disponibilite(false)
					.build());

			// creation du nouveau livraison
			commandeRepository.findAll().forEach(commande -> {
				LocalDate date = commande.getDateCommande(); // definition de la date actuelle
				LocalDate nextDay = date.plusDays(1); // +1 le jour de la date courant
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formatNextDay = nextDay.format(dateTimeFormatter);

				List<Livreur> livreursList = livreurRepository.findAll();
				List<Livreur> livreursDisponibles = new ArrayList<>();
				livreursList.forEach(livreur -> {
					if (livreur.isDisponibilite()){
						livreursDisponibles.add(livreur);
					}
				});
				if (!livreursDisponibles.isEmpty()) {
					int compteur = livreursDisponibles.size();
					livraisonRepository.save(Livraison.builder()
							.dateLivraison(formatNextDay)
							.commandes(commande)
							.livreur(livreursDisponibles.get(random.nextInt(compteur)))
							.livrer(false)
							.build());
				} else if (!livreursList.isEmpty()) {
					int compteur = livreursList.size();
					livraisonRepository.save(Livraison.builder()
							.dateLivraison(formatNextDay)
							.commandes(commande)
							.livreur(livreursList.get(random.nextInt(compteur)))
							.livrer(false)
							.build());
				} else {
					System.out.println("Aucun livreur trouvé.");
				}
			});

		};
	}
}
