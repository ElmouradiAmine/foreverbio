package com.itwins.foreverbio.controllers;

import java.util.List;
import java.util.Map;

import com.itwins.foreverbio.models.Category;
import com.itwins.foreverbio.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.itwins.foreverbio.services.CategoryService;

@org.springframework.web.bind.annotation.RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @CrossOrigin("http://localhost:3000")
    @PostMapping("Category/add")
    public Category addCategory(@RequestBody Map<String, Object> categoryMap) {
        Category category = new Category(categoryMap);
       // categoryService.saveCategory(category);

        return categoryService.saveCategory(category);
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("Category/all")
    public List<Category> findAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        if (categories == null) {
            return null;
        }
        return categories;


    }
    @CrossOrigin()
    @DeleteMapping("Category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {

        if (categoryService.deleteCategory(id)) {
            return "{" + "The Category has been deleted sucessfully" + "}";
        }

        return " An error has occured. ";
    }
    @CrossOrigin()
    @GetMapping("Category/{id}")
    public Category getCategory(@PathVariable int id) {
        Category category = categoryService.findCategory(id);
        if (category == null) {
            return null;		}
        return category;

//        return "{ id\": \""
//                + category.getId() + "\"," + "\"libelle\": \"" + category.getNom() + "\"." ;
    }

    @CrossOrigin()
    @PutMapping("Category/edit/{id}")
    public Category editCategory(@PathVariable int id,@RequestBody Map<String, Object> categoryMap) {

        Category cat = categoryService.findCategory(id);// new Category(categoryMap);
        cat.setNom((String) categoryMap.get("nom"));
        cat.setImage((String) categoryMap.get("image"));
        cat.setDescription((String) categoryMap.get("description"));
        categoryService.saveCategory(cat);
        return cat;

    }

    /*@GetMapping("Category/{id}")
    public Category getProducts(@PathVariable int id) {
        Category category = categoryService.findCategory(id);
        if (category == null) {
            return null;
        }
        return category;


    }*/


}
