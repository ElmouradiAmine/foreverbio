package com.itwins.foreverbio.services;


import com.itwins.foreverbio.models.LigneCommande;
import com.itwins.foreverbio.repository.LigneCommandeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }


    public List<LigneCommande> getAllCommandes() {
        return ligneCommandeRepository.findAll();
    }
    public LigneCommande addLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepository.save(ligneCommande);
    }

    public List<LigneCommande> getLigneCommandesByCommandeId(int commandeId) {
        return ligneCommandeRepository.findByCommandeId(commandeId);
    }

}
