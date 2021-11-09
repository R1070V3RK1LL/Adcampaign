package com.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
