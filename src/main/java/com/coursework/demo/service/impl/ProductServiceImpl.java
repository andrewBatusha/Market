package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Product;
import com.coursework.demo.repository.ProductRepository;
import com.coursework.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public Product update(Product object) {
        return productRepository.save(object);
    }

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public Product delete(Product object) {
        productRepository.delete(object);
        return object;
    }
}
