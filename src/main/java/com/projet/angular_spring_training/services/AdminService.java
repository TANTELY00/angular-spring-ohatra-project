package com.projet.angular_spring_training.services;

import com.projet.angular_spring_training.dto.AdminDTO;
import com.projet.angular_spring_training.entities.Admin;
import com.projet.angular_spring_training.repositories.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // SAVE ADMIN
    public Admin saveAdmin(AdminDTO adminDTO){
        Admin admin = Admin.builder()
                .nom(adminDTO.getNom())
                .prenoms(adminDTO.getPrenoms())
                .telephone(adminDTO.getTelephone())
                .email(adminDTO.getEmail())
                .mdp(adminDTO.getMdp())
                .role(adminDTO.getRole())
                .photos(adminDTO.getPhotos())
                .adresse(adminDTO.getAdresse())
                .build();
        return  adminRepository.save(admin);
    }
}
