package com.frantoionapoli.service;


import com.frantoionapoli.model.Category;
import com.frantoionapoli.model.Product;
import com.frantoionapoli.repository.CategoryRepository;
import com.frantoionapoli.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public Product saveProduct(Product product) {
        Integer categoryId = product.getCategory().getId();
        Category category = categoryService.getCategoryById(categoryId);
        product.setCategory(category);
        Product productCreated = productRepository.save(product);
        return productCreated;
    }
}
