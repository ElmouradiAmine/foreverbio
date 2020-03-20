package com.itwins.foreverbio.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwins.foreverbio.services.ProductService;

import com.itwins.foreverbio.models.Product;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // ! @route GET /product
    // ! @desc shows all products in mysql database
    // ! @access public
    @GetMapping("/product")
    public List<Product> index() {
        return productService.findAll();
    }

    // ! @route GET /product/id
    // ! @desc finds and shows product with parameter id
    // ! @access public
    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable String id) {
        int productId = Integer.parseInt(id);
        return productService.findById(productId);
    }

    // ! @route POST /product/search
    // ! @desc uses body parameter : "text" and finds a product with
    // name or description that contains the text input
    // ! @access public
    @PostMapping("/product/search")
    public List<Product> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return productService.findByNomContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    // ! @route POST /product
    // ! @desc adds product in database. Body parameters needed :
    // id, nom, description, source, etat, prix, qte
    // exemple :
    // {
    // "id":"5",
    // "nom":"produit1",
    // "description":"description produit1",
    // "source":"source1",
    // "etat":"vente",
    // "prix":"100.00",
    // "qte":"34"
    // }
    // ! @access public (for now- it should be accessible by admins only)
    @PostMapping("/product")
    public Product create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String nom = body.get("nom");
        String description = body.get("description");
        String source = body.get("source");
        String etat = body.get("etat");
        double prix = Double.parseDouble(body.get("prix"));
        int qte = Integer.parseInt(body.get("qte"));

        return productService.saveProduct(new Product(id, nom, description, source, etat, prix, qte));
    }

    // ! @route PUT /product/id
    // ! @desc modifies product in database. Body parameters needed :
    // id, nom,description, source, etat, prix, qte
    // ! @access public (for now- it should be accessible by admins only)
    @PutMapping("/product/{" +
            "}")
    public Product update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int productId = Integer.parseInt(id);
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            Product p = product.get();
            p.setNom(body.get("nom"));
            p.setDescription(body.get("description"));
            p.setSource(body.get("source"));
            p.setEtat(body.get("etat"));
            p.setPrix(Double.parseDouble(body.get("prix")));
            p.setQte(Integer.parseInt(body.get("qte")));

            return productService.saveProduct(p);
        }
        return null;
    }

    // ! @route DELETE /product/id
    // ! @desc deletes product with param id
    // ! @access public (for now- it should be private for admins)
    @DeleteMapping("product/{id}")
    public boolean delete(@PathVariable String id) {
        int productId = Integer.parseInt(id);
        try {
            productService.deleteById(productId);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
