package com.store.app.service;

import com.store.app.entity.Product;
import com.store.app.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    @NonNull
    private ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
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