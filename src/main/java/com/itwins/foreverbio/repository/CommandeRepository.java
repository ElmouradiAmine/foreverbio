package com.itwins.foreverbio.repository;

import com.itwins.foreverbio.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommandeRepository  extends  JpaRepository<Commande, Integer>{
    List<Commande> findByUserId(int userId);
}
