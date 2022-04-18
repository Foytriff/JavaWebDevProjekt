package com.example.javawebdevprojekt.security;

import com.example.javawebdevprojekt.entities.Anv;
import com.example.javawebdevprojekt.entities.Konsult;
import com.example.javawebdevprojekt.repositories.KonsultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    KonsultRepo konsultRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Konsult konsult = konsultRepo.findKonsultByUsername(username).orElseThrow();

        return new User(konsult.getUsername(), konsult.getPassword(), List.of());
    }
}
