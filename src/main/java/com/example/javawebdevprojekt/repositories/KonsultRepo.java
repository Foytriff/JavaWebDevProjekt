package com.example.javawebdevprojekt.repositories;

import com.example.javawebdevprojekt.entities.Konsult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonsultRepo extends JpaRepository<Konsult, Integer> {
}
