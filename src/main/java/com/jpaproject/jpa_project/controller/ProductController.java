package com.jpaproject.jpa_project.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jpaproject.jpa_project.model.Product;
import com.jpaproject.jpa_project.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class ProductController {
    
    private final ProductRepository repository;
    
    public ProductController(final ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repository.findAll();
    }
    
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return this.repository.findById(id).get();
    }

    @PostMapping("/products/")
    public Product postProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
        Optional<Product> optionalProduct = this.repository.findById(id);
        if(!optionalProduct.isPresent()) {
            return null;
        }
        Product productToUpdate = optionalProduct.get();
        if(product.getName() != null) {
            productToUpdate.setName(product.getName());
        }
        if(product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if(product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        Product updatedProduct = this.repository.save(productToUpdate);
        return updatedProduct;
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Integer id) {
        Optional<Product> optionalProductToDelete = this.repository.findById(id);
        if(!optionalProductToDelete.isPresent()) {
            return null;
        }
        Product productToDelete = optionalProductToDelete.get();
        this.repository.delete(productToDelete);
        return productToDelete;
    }
    
}
