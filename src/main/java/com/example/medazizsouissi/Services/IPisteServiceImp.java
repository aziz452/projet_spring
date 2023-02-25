package com.example.medazizsouissi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.medazizsouissi.Entities.Piste;
import com.example.medazizsouissi.Repositories.PisteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IPisteServiceImp implements IPisteService{

    @Autowired
    PisteRepository pisteRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return  pisteRepository.findAll();    }

    @Override
    public Piste addPiste(Piste piste) {
         return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Optional<Piste> retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }
}
