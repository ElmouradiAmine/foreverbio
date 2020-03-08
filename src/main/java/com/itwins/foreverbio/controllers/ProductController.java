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

@org.springframework.web.bind.annotation.RestController
public class ProductController {

	@Autowired 
	private ProductService productService;
	
	@GetMapping("/product")
    public List<Product> index(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable String id){
        int productId = Integer.parseInt(id);
        return productService.findById(productId);
    }

    @PostMapping("/product/search")
    public List<Product> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return productService.findByNomContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    @PostMapping("/product")
    public Product create(@RequestBody Map<String, String> body){ 
    	int id = Integer.parseInt(body.get("id"));
        String nom = body.get("nom");
        String description = body.get("description");
        String source = body.get("source");
        String etat = body.get("etat");
        double prix = Double.parseDouble(body.get("prix"));
        int qte = Integer.parseInt(body.get("qte"));
        
        return productService.saveProduct(new Product(id, nom, description, source, etat, prix, qte));
    }

    @PutMapping("/product/{id}")
    public Product update(@PathVariable String id, @RequestBody Map<String, String> body){
        int productId = Integer.parseInt(id);
        Optional<Product> product = productService.findById(productId);
        if(product.isPresent()) {
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

    @DeleteMapping("product/{id}")
    public boolean delete(@PathVariable String id){
        int productId = Integer.parseInt(id);
        try {
        	productService.deleteById(productId);
            return true;
        	
        } catch(Exception e ) {
        	return false;
        }
    }
}
