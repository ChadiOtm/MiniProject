package com.sid.msbanque.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;

    @OneToMany(mappedBy = "client")
    private Collection<Compte> Comptes ;
}
