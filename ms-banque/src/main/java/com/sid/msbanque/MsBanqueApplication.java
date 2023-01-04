package com.sid.msbanque;

import com.sid.msbanque.Repositories.ClientRepository;
import com.sid.msbanque.Repositories.CompteRepository;
import com.sid.msbanque.entities.Client;
import com.sid.msbanque.entities.Compte;
import com.sid.msbanque.entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository Compterepository,ClientRepository ClientRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Compte.class);
			Client c1 =ClientRepository.save(new Client(null,"otmane",null));
			Client c2 =ClientRepository.save(new Client(null,"chadi",null));

			Compterepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c1));
			Compterepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c1));
			Compterepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT,c2));
			Compterepository.findAll().forEach(c -> {
				System.out.println(c.getSolde());
			});
			;
		};
	}

}
