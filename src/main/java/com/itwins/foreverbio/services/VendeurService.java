package com.itwins.foreverbio.services;

import com.itwins.foreverbio.models.Vendeur;

public class VendeurService {
    private  VendeurService vendeurService;

    /*public VendeurService(VendeurService vendeurService) {
        this.vendeurService = vendeurService;
    }*/

    public void delete(Vendeur vendeur) {
        vendeurService.delete(vendeur);
    }
    public Vendeur findById(int id){
        return vendeurService.findById(id);
    }
}
