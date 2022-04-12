package com.example.javawebdevprojekt.repositories;

import com.example.javawebdevprojekt.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation, Integer> {

}
