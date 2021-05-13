package com.capg.msc.myshoppingcart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.msc.myshoppingcart.beans.*;


public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
	
}
