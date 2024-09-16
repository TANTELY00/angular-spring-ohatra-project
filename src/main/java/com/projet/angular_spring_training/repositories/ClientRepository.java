package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
