package com.capg.msc.myshoppingcart.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.msc.myshoppingcart.beans.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional
	public Product saveProduct(Product p) {
		// TODO Auto-generated method stub
		repo.save(p);
		return p;
	}
    @Override
    @Transactional
	public boolean deleteProduct(Product p, int pId) {
		boolean isDeleted = false;
		Product p1 = null;
		List<Product> pList = getAllProducts();
		for(Product product : pList) {
			if(product.getProductId() == pId) {
				isDeleted = true;
				p1 = product;
			}
		}
	
		repo.delete(p);
		return isDeleted;
		
	}
    @Override
	public Product updateProduct(Product p,int id) {
		Optional<Product> toUpdate=repo.findById(id);
		if(toUpdate.isPresent())
		{
			Product product=toUpdate.get();
			product.setProductName(p.getProductName());
			product.setProductCost(p.getProductCost());
			product.setStarRating(p.getStarRating());
			product.setCategory(p.getCategory());
			return repo.save(product);
		}
		return null;
	}
}
