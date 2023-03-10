package com.example.medazizsouissi.Repositories;

import com.example.medazizsouissi.Entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medazizsouissi.Entities.Skieur;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long > {

    List<Skieur> findSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);



}
