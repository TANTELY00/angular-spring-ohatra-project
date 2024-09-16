package com.projet.angular_spring_training.repositories;

import com.projet.angular_spring_training.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
