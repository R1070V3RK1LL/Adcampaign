package com.telecom.service;

import com.telecom.model.Product;
import com.telecom.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private com.telecom.repository.ProductRepository ProductRepository;
    public List<Product> findAllProducts(){
        return this.ProductRepository.findAll();
    }
}




