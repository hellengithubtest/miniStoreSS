package com.store.app.service;

import com.store.app.entity.Product;
import com.store.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        Page<Product> pages = productRepository.findAll(pageable);
        return pages;
    }

    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public Page<Product> search(String name, Pageable pageable) {
        return  productRepository.findByNameContainingIgnoreCase(name, pageable);
    }


}