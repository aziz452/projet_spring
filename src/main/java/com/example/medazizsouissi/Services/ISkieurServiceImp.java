package com.example.medazizsouissi.Services;

import com.example.medazizsouissi.Entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.medazizsouissi.Entities.Abonnement;
import com.example.medazizsouissi.Entities.Piste;
import com.example.medazizsouissi.Entities.Skieur;
import com.example.medazizsouissi.Repositories.AbonnementRepository;
import com.example.medazizsouissi.Repositories.PisteRepository;
import com.example.medazizsouissi.Repositories.SkieurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ISkieurServiceImp implements ISkieurService{
    @Autowired
    SkieurRepository skieurRepository;
    @Autowired

    PisteRepository pisteRepository;
    @Autowired
    AbonnementRepository abonnementRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return  skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Optional<Skieur> retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur);
    }

    @Override
    public Skieur updateSkieur(Skieur Skieur) {
        return skieurRepository.save(Skieur);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
Skieur skieur=skieurRepository.findById(numSkieur).orElse(null) ;
Piste piste=pisteRepository.findById(numPiste).orElse(null);
 if(skieur!=null && piste!=null){
     List<Piste>pistes=skieur.getPistes();
     pistes.add(piste);
     skieur.setPistes(pistes);
     return  skieurRepository.save(skieur);

 }
 return null;
    }

    @Override
    public Skieur AssignSkierToSubscription(long numSkieur, long numAbon) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null) ;
        Abonnement abonnement=abonnementRepository.findById(numAbon).orElse(null);
        if(skieur!=null && abonnement!=null){

            skieur.setAbonnement(abonnement);

            return  skieurRepository.save(skieur);

        }
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findSkieurByAbonnement_TypeAbon(typeAbonnement);
    }
}
