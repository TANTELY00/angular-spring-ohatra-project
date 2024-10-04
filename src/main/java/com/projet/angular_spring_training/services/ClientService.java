package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.dto.ClientDTO;
import com.projet.angular_spring_training.entities.Client;
import com.projet.angular_spring_training.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    // METHOD FOR SAVE CLIENT
    public Client saveClient(ClientDTO clientDTO){
        Client client = Client.builder()
                .nom(clientDTO.getNom())
                .prenoms(clientDTO.getPrenoms())
                .adresse(clientDTO.getAdresse())
                .email(clientDTO.getEmail())
                .telephone(clientDTO.getTelephone())
                .photos(clientDTO.getPhotos())
                .region(clientDTO.getRegion())
                .build();
        return clientRepository.save(client);
    }

}
