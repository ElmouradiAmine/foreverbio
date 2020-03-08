package com.itwins.foreverbio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.foreverbio.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNomContainingOrDescriptionContaining(String nom, String description);
}
