package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository resp;
    public List<Product> viewAll(){
    	List<Product> product=resp.findAll();
		return product;
    }
    public Optional<Product> findbyName(String name) {
    	Optional<Product> pro=resp.findByName(name);
    	return pro;
    }
    public Product update(int id) {
    	Optional<Product> product=resp.findById(id);
    	Product product1=product.get();
    	return product1;
    }
    public Optional<Product> findById(int id) {
    	Optional<Product> prod=resp.findById(id);
    	return prod;
    }
    public void save(Product product) {
    	resp.save(product);
    }
}
