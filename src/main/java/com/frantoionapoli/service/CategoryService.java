package com.frantoionapoli.service;

import com.frantoionapoli.model.Category;
import com.frantoionapoli.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

}
