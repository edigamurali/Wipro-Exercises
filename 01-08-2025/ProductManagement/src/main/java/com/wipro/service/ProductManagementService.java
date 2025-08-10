package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.entity.ProductManagement;
import com.wipro.repository.ProductManagementRepo;

@Service
public class ProductManagementService implements ProductManagementInterface {

	@Autowired
	ProductManagementRepo productManagementRepo;
	
	@Override
	public void saveProduct(ProductManagement productManagement) {
		
		productManagementRepo.save(productManagement);
	}

	@Override
	public List<ProductManagement> findAllProducts() {
		
		return productManagementRepo.findAll();
	}

	@Override
	public ProductManagement findProductById(int id) {
		Optional<ProductManagement> product=productManagementRepo.findById(id);
		if(!product.isEmpty())
			return product.get();
		return null;
	}

	@Override
	public void deleteProductById(int id) {
		
		productManagementRepo.deleteById(id);
	}

	@Override
	public List<ProductManagement> findByProductName(String productName) {
		
		return productManagementRepo.findByProductName(productName);
	}

	@Override
	public List<ProductManagement> findByProductNameAndProductMakeOrderByProductNameDesc(String productName,
			String productMake) {
		
		return productManagementRepo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}

	@Override
	public Page<ProductManagement> findAll(Pageable p) {
		
		return productManagementRepo.findAll(p);
	}

}
