package com.itwins.foreverbio.repository;
import org.springframework.data.repository.CrudRepository;

import com.itwins.foreverbio.models.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {


    List<Category> findByNomContaining(String nom);
}
