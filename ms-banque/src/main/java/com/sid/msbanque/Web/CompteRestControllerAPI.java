package com.sid.msbanque.Web;
import com.sid.msbanque.Repositories.CompteRepository;
import com.sid.msbanque.entities.Compte;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {

    @Autowired
    private CompteRepository compteRepository;
    @GetMapping("/comptes")
    public List<Compte> ListCompte(){
        return compteRepository.findAll();
    }

    @GetMapping("/compte/{id}")
    public Compte getCompte(@PathVariable(value ="id" ) Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping("/add")
    public Compte AddCompte(Compte compte){
        return compteRepository.save(compte);
    }
    @PutMapping("/compte/{id}")
    public Compte UpdateCompte(Compte compte , @PathVariable(value = "id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping("/Delete/{id}")
    public void DeleteCompte(@PathVariable(value = "id") Long id){
        compteRepository.deleteById(id);
    }
}

