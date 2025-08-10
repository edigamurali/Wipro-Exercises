package com.wipro.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.entity.ProductManagement;

public interface ProductManagementInterface {
	public void saveProduct(ProductManagement productManagement);
	public List<ProductManagement> findAllProducts();
	public ProductManagement findProductById(int id);
	public void deleteProductById(int id);
	public List<ProductManagement> findByProductName(String productName);
	public List<ProductManagement> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake);
	Page<ProductManagement>  findAll(Pageable p); 

}
