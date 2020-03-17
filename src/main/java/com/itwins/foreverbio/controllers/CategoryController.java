package com.itwins.foreverbio.controllers;

import java.util.List;
import java.util.Map;

import com.itwins.foreverbio.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwins.foreverbio.services.CategoryService;

@org.springframework.web.bind.annotation.RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("Category/add")
    public String addCategory(@RequestBody Map<String, Object> categoryMap) {
        Category category = new Category(categoryMap);
        categoryService.saveCategory(category);

        return "{" + "category saved successfully." + "}";
    }

    @PostMapping("Category/all")
    public String findAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        if (categories == null) {
            return "{" + "An error has occured." + "}";
        }

        String jsonBody = "\"Categories\": [ ";
        int i = 0;
        for (Category category : categories) {

            jsonBody += category.toString();
            if (i != categories.size() - 1) {
                jsonBody += ",";
            }
            i++;

        }

        jsonBody += "]";
        return jsonBody;
    }

    @GetMapping("Category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {

        if (categoryService.deleteCategory(id)) {
            return "{" + "The Category has been deleted sucessfully" + "}";
        }

        return " An error has occured. ";
    }

    @GetMapping("Category/{id}")
    public String getCategory(@PathVariable int id) {
        Category category = categoryService.findCategory(id);
        if (category == null) {
            return "An error has occured. ";		}


        return "{ id\": \""
                + category.getId() + "\"," + "\"libelle\": \"" + category.getNom() + "\"." ;
    }


    @PostMapping("Category/edit")
    public String editCategory(@RequestBody Map<String, Object> categoryMap) {
        Category user = new Category(categoryMap);
        categoryService.saveCategory(user);
        return "{" + "\"statusCode\": 1," + "\"description\": \"Catgory updated successfully.\"" + "}";

    }




}
