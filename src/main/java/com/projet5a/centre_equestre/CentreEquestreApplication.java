package com.projet5a.centre_equestre;

import com.projet5a.centre_equestre.model.Utilisateur;
import com.projet5a.centre_equestre.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CentreEquestreApplication {

	private static final Logger log = LoggerFactory.getLogger(CentreEquestreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CentreEquestreApplication.class, args);
	}

	@Bean
	public CommandLineRunner compteAdministrateur(UtilisateurRepository utilisateurRepository) {
		return (args) -> {
			// création d'un compte Administrateur dans la base de données
			utilisateurRepository.save(new Utilisateur("admin@centreequestre.fr", "root","Admin","administrateur", "0102030405", "", "admin"));
		};
	}

}
