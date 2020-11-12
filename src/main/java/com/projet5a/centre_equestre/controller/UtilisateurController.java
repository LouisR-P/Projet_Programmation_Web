package com.projet5a.centre_equestre.controller;

import com.projet5a.centre_equestre.model.Utilisateur;
import com.projet5a.centre_equestre.repository.UtilisateurRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UtilisateurController {

    private UtilisateurRepository utilisateurRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> Utilisateurs(){
        return utilisateurRepository.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> Utilisateur(@PathVariable Long id){
        return utilisateurRepository.findById(id);
    }

    @PostMapping("/utilisateurs")
    public @ResponseBody void inscrireUtilisateur(@RequestBody Utilisateur inscrireUtilisateur) throws IOException {
        inscrireUtilisateur.setMotDePasse(passwordEncoder().encode(inscrireUtilisateur.getMotDePasse()));
        utilisateurRepository.save(inscrireUtilisateur);
    }

    @DeleteMapping("/suppressionUtilisateur/{id}")
    public @ResponseBody String supprimerUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
        return "Compte utilisateur supprimé.";
    }

}
