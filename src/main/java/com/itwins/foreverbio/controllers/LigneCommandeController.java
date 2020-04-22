package com.itwins.foreverbio.controllers;


import com.itwins.foreverbio.models.Commande;
import com.itwins.foreverbio.models.LigneCommande;
import com.itwins.foreverbio.models.Product;
import com.itwins.foreverbio.services.LigneCommandeService;
import com.itwins.foreverbio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;
    @Autowired
    private ProductService productService;


    @PostMapping("/commandes/{commandeId}/ligneCommande/{productId}")
    public LigneCommande addLigneCommande(@RequestBody LigneCommande ligneCommande, @PathVariable int commandeId, @PathVariable int productId){
        ligneCommande.setCommande(new Commande(commandeId));
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()){
            ligneCommande.setProduct(product.get());
            return ligneCommandeService.addLigneCommande(ligneCommande);
        }
        return null;



    }


}
