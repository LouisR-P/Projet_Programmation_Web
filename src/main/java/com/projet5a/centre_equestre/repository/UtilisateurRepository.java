package com.projet5a.centre_equestre.repository;

import com.projet5a.centre_equestre.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByNom(String nom);

    Boolean existsByNom(String nom);

    Boolean existsByEmail(String email);

}