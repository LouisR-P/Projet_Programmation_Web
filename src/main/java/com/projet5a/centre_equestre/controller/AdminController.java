package com.projet5a.centre_equestre.controller;


import com.projet5a.centre_equestre.model.Utilisateur;
import com.projet5a.centre_equestre.repository.UtilisateurRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role/admin")
public class AdminController {

    private UtilisateurRepository utilisateurRepository;

    public AdminController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> Utilisateurs(){
        return utilisateurRepository.findAll();
    }


}
