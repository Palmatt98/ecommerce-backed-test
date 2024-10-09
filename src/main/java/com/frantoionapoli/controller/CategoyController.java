package com.frantoionapoli.controller;

import com.frantoionapoli.model.Category;
import com.frantoionapoli.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoyController {

    @Autowired
    private CategoryService categoryService;

    //nella post usualmente si mette il body
    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        //salvo la categoria
        //ritorno la categoria salvata con httpstatus
        Category categoryCreated = categoryService.saveCategory(category);
        return new ResponseEntity<>(categoryCreated, HttpStatus.CREATED);

    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> listCategory = categoryService.getCategories();
            return new ResponseEntity<>(listCategory, HttpStatus.OK);
    }

}
