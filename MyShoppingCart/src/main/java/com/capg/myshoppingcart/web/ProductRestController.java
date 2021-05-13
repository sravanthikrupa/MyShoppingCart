package com.capg.myshoppingcart.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.beans.Product;
import com.capg.msc.myshoppingcart.service.ProductService;



@RestController
@RequestMapping("/api")
public class ProductRestController {

	
	
	@Autowired
	private ProductService service;
	
	
	public ProductRestController() {
		System.out.println("-------------->> Product Rest Controller Constructor");
	}
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome: My Shopping APP " +LocalDateTime.now();
		
	}
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product product) {
		service.saveProduct(product);
		return product;
	}
	
	
	
	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PostMapping("/product/delete")
	public boolean deleteProduct(@RequestBody Product p) {
		return service.deleteProduct(p , p.getProductId());
	}
	@PutMapping("/product/{id}")
	public Product updateProduct(@RequestBody Product p,@PathVariable int id)
	{
		return service.updateProduct(p, id);
	}
}