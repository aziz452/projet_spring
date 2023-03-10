package com.example.medazizsouissi.Repositories;

import com.example.medazizsouissi.Entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medazizsouissi.Entities.Abonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long > {
    List<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    List<Abonnement> findAbonnementByDateDebutAndDateFin(LocalDate startDate, LocalDate endDate);
}
