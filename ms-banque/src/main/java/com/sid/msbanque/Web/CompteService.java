package com.sid.msbanque.Web;

import com.sid.msbanque.Repositories.CompteRepository;
import com.sid.msbanque.entities.Compte;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@WebService(serviceName = "BanqueWS")
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @WebMethod

    public List<Compte> ListCompte(){
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get();
    }

}
