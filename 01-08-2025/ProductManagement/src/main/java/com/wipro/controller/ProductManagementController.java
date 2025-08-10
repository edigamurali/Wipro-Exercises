package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.ProductManagement;
import com.wipro.service.ProductManagementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product")
@Tag(name = "ProductManagementApI", description = "Product management APIs")
public class ProductManagementController {
	
	@Autowired
	ProductManagementService productService;
	
	//Swagger API
	@Operation(summary = "Save a product")
	  @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Saved successfully"),
	    @ApiResponse(responseCode = "404", description = "Not found")
	  })
	@PostMapping
	public void saveProduct(@RequestBody ProductManagement productManagement)
	{
		productService.saveProduct(productManagement);
	}
	@GetMapping
	public List<ProductManagement> findAllProducts()
	{
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public ProductManagement findProductById(@PathVariable int id)
	{
		return productService.findProductById(id);
	}
	@PutMapping
	public void update(@RequestBody ProductManagement productManagement)
	{
		productService.saveProduct(productManagement);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		productService.deleteProductById(id);
		
	}
	
	@GetMapping("/name/{productName}")
	public List<ProductManagement> findByProductName(@PathVariable String productName)
	{
		return productService.findByProductName(productName);
	}
	
	@GetMapping("/order/{productName}/{productMake}")
	public List<ProductManagement> findByProductNameAndProductMakeOrderByProductName(@PathVariable String productName,@PathVariable String productMake)
	{
		return productService.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}
	
	
	
	@GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
	public Page<ProductManagement> findAllPage(@PathVariable int  pageNum,@PathVariable int  pageSize,@PathVariable int  sortOrder) {
		Pageable p=null;
	  if(sortOrder==0)
	  {
		  p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").descending());
	  }
	  else
	  {
		    p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").ascending());
	  }
		
		return productService.findAll(p);
	}


}
