package com.projet5a.centre_equestre.security.services;

import com.projet5a.centre_equestre.model.Utilisateur;
import com.projet5a.centre_equestre.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByNom(nom)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nom));

        return UserDetailsImpl.build(utilisateur);
    }

}