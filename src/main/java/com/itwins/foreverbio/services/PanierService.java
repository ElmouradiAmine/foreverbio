package com.itwins.foreverbio.services;

import com.itwins.foreverbio.models.Panier;
import com.itwins.foreverbio.repository.PanierRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PanierService {

    private final PanierRepository panierRepository;

    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    public void delete(Panier panier) { panierRepository.delete(panier);};
    public Panier findById(int id) {return  panierRepository.findById(id);};
    public List<Panier> findByPrixGreaterThan(int prixLimit) {return panierRepository.findByPrixGreaterThan(prixLimit);};
}
