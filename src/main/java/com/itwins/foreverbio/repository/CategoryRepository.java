package com.itwins.foreverbio.repository;
import org.springframework.data.repository.CrudRepository;

import com.itwins.foreverbio.models.Category;
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Category findById(int id);


}
