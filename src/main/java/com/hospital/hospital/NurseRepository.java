package com.hospital.hospital;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring automatically implements this repository
// CRUD refers to Create, Read, Update and Delete
public interface NurseRepository extends JpaRepository<Nurse, Integer> {

    // Find a nurse by user and password (login)
    Optional<Nurse> findByUsernameAndPassword(String username, String password);

    // Find a nurse by name
    Optional<Nurse> findByName(String name);
}