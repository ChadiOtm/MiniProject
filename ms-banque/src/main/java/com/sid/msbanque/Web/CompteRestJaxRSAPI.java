package com.sid.msbanque.Web;

import com.sid.msbanque.Repositories.CompteRepository;
import com.sid.msbanque.entities.Compte;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> ListCompte(){
        return compteRepository.findAll();
    }

    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getCompte(@PathParam(value ="id" ) Long id){
        return compteRepository.findById(id).get();
    }

    @Path("/add")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte AddCompte(Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/compte/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte UpdateCompte(Compte compte , @PathParam(value = "id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/Delete/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void DeleteCompte(@PathParam(value = "id") Long id){
        compteRepository.deleteById(id);
    }
}
