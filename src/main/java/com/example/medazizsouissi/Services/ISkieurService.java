package com.example.medazizsouissi.Services;

import com.example.medazizsouissi.Entities.*;
import com.example.medazizsouissi.Entities.TypeAbonnement;
import com.example.medazizsouissi.Entities.Couleur;
import com.example.medazizsouissi.Entities.TypeCours;
import org.springframework.data.repository.query.Param;



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
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur);
    List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@Param("support") Support support, @Param("nom") String nom);
    Skieur addSkierAndAssignToCourse(Skieur skieur);
    List<Skieur> findSkieursByPisteCouleur(Couleur couleur);
}
