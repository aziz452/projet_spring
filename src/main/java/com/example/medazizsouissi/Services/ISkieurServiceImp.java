package com.example.medazizsouissi.Services;

import com.example.medazizsouissi.Entities.*;
import com.example.medazizsouissi.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    InscriptionRepository inscriptionRepository;

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

    @Override
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur) {
        return skieurRepository.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(inscriptions_cours_typeCours, inscriptions_cours_support, pistes_couleur);    }

    @Override
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(Support support, String nom) {
        return skieurRepository.findByMoniteurNameAndSupportTypeJPQL(support,nom);    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnement(),"Abonnement must be entered!!!"); //vérifier si l'objet abonn existe
        Assert.notNull(skieur.getInscriptions(),"Inscription must be entered!!!!");
        List<Inscription> inscriptions=skieur.getInscriptions();
        inscriptions.forEach(inscription -> {   //nparcouri liste taa inscrip w netfaked ken kol inscri aandha cours
            Assert.notNull(inscription.getCours().getNumCours(),"Cours must be entered!!!");
            Cours cours= coursRepository.findById(inscription.getCours().getNumCours()).orElse(null);
            Assert.notNull(cours,"No cours found with this id!!!");
            inscription.setCours(cours); //inscription aandou cours barka donc l inscrip houa li bech ygéri l relation et il va affecter inscrip lel cours
            //taw ki bech ntestiw , exception handler
        });
        skieurRepository.saveAndFlush(skieur); //ken bech nhotha dekhel l for mch bech ysajel les controles de saisie donc nhotha l bara w naawed naamel for lel skieur
        skieur.getInscriptions().forEach(inscription ->{
            inscription.setSkieur(skieur);
            inscriptionRepository.saveAndFlush(inscription);
        });
        return skieur;    }

    @Override
    public List<Skieur> findSkieursByPisteCouleur(Couleur couleur) {
        return skieurRepository.findSkieursByPisteCouleur(couleur);    }
}
