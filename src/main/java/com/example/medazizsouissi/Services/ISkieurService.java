package com.example.medazizsouissi.Services;

import com.example.medazizsouissi.Entities.Skieur;

import java.util.List;
import java.util.Optional;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);


    void removeSkieur (Long numSkieur);
    Optional<Skieur> retrieveSkieur (Long numSkieur);
    Skieur updateSkieur (Skieur Skieur);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur AssignSkierToSubscription(long numSkieur, long numAbon);

}
