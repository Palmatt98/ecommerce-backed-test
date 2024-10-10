package com.frantoionapoli.service;

import com.frantoionapoli.model.Category;
import com.frantoionapoli.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        Category categoryCreated = categoryRepository.save(category);
        return categoryCreated;
    }

    public List<Category> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category getCategoryById(Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return category;
        } else {
            return null;
        }
    }

    public void deleteAuto(Integer id) {
        categoryRepository.deleteById(id);
    }

}
