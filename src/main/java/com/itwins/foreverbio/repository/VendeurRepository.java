package com.itwins.foreverbio.repository;

import com.itwins.foreverbio.models.Panier;
import com.itwins.foreverbio.models.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendeurRepository extends JpaRepository<Vendeur,Integer> {
    void delete(Vendeur vendeur);
    public Vendeur findById(int id);
}
