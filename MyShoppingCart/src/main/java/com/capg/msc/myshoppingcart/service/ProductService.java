package com.capg.msc.myshoppingcart.service;

import java.util.List;

import com.capg.msc.myshoppingcart.beans.Product;

public interface ProductService {
public List<Product> getAllProducts();

public Product saveProduct(Product p);


boolean deleteProduct(Product p, int id);
public Product updateProduct(Product p,int id);


}
