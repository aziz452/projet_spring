package com.example.medazizsouissi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medazizsouissi.Entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription,Long > {
}
