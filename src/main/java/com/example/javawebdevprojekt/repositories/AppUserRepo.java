package com.example.javawebdevprojekt.repositories;

import com.example.javawebdevprojekt.entities.Anv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepo extends JpaRepository<Anv, Integer> {
    List<Anv> findByUsername(String username);
}
