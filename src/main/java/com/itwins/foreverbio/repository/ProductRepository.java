package com.itwins.foreverbio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.foreverbio.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNomContainingOrDescriptionContaining(String nom, String description);
	//@)Query("Select id from products where idCat=:idCateg"
	List<Product> findProductByIdCat(int idCat );


}
