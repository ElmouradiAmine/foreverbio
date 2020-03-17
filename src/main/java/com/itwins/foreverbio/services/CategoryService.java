package com.itwins.foreverbio.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.itwins.foreverbio.models.Category;
import com.itwins.foreverbio.repository.CategoryRepository;

@Service
@Transactional

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public boolean deleteCategory(int id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Category findCategory(int id) {

        return categoryRepository.findById(id);

    }

    public void updateCategory(Category category) {
        deleteCategory(category.getId());
        categoryRepository.save(category);
    }

}

