package com.itwins.foreverbio.repository;

import com.itwins.foreverbio.models.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

    List<LigneCommande> findByCommandeId(int commandeId);
}
