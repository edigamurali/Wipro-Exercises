package com.wipro.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.ProductManagement;

public interface ProductManagementRepo extends JpaRepository<ProductManagement, Integer>{
	
	
	 List<ProductManagement> findByProductName(String productName);
	 List<ProductManagement> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);
	 Page<ProductManagement>  findAll(Pageable p); 

}
