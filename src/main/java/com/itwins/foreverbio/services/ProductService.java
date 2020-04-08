package com.itwins.foreverbio.services;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itwins.foreverbio.models.Product;
import com.itwins.foreverbio.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}
	
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> findByNomContainingOrDescriptionContaining(String nom, String description) {
		return productRepository.findByNomContainingOrDescriptionContaining(nom, description);
	}
//AH FHMT ! SAF WLITI SUPERWOMAN HHHHHH ACH BA9I  DAR M3AK AMINE ? Z3MA CHEF
	//EWA SBRI NCHOFO 3MI GOOGLE T9LAB DIALK MACHI HWA DIALI
	public List<Product> findProductByIdCat(int idCateg) {
		return productRepository.findProductByIdCat(idCateg);
	}


	
}
