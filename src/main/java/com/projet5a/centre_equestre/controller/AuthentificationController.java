package com.projet5a.centre_equestre.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.projet5a.centre_equestre.model.ERole;
import com.projet5a.centre_equestre.model.Role;
import com.projet5a.centre_equestre.model.Utilisateur;
import com.projet5a.centre_equestre.payload.request.ConnexionRequest;
import com.projet5a.centre_equestre.payload.request.InscriptionRequest;
import com.projet5a.centre_equestre.payload.response.JwtResponse;
import com.projet5a.centre_equestre.payload.response.MessageResponse;
import com.projet5a.centre_equestre.repository.RoleRepository;
import com.projet5a.centre_equestre.repository.UtilisateurRepository;
import com.projet5a.centre_equestre.security.jwt.JwtUtils;
import com.projet5a.centre_equestre.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> connexionUtilisateur(@Valid @RequestBody ConnexionRequest connexionRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(connexionRequest.getNom(), connexionRequest.getMotDePasse()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> inscriptionUtilisateur(@Valid @RequestBody InscriptionRequest signUpRequest) {
        if (utilisateurRepository.existsByNom(signUpRequest.getNom())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Ce nom est déjà utilisé."));
        }

        if (utilisateurRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Cet adresse email est déjà utilisé."));
        }

        // Create new user's account
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getMotDePasse()),
                signUpRequest.getNom(),
                signUpRequest.getPrenom(),
                signUpRequest.getNumero(),
                signUpRequest.getLicence());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Erreur: Role introuvable."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Erreur: Role introuvable."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Erreur: Role introuvable."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Erreur: Role introuvable."));
                        roles.add(userRole);
                }
            });
        }

        utilisateur.setRoles(roles);
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok(new MessageResponse("Utilisateur inscrit !"));
    }
}
