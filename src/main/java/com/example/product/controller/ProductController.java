package com.example.product.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.ProductModel;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/demo")
public class ProductController {
	@Autowired
	ProductService productserv;
	
	@GetMapping("/products")
	List<ProductModel> getAll()
	{
		return productserv.getAll();
	}
	
	@PostMapping("/products")
	ResponseEntity<String> addTrainee(@Valid @RequestBody ProductModel pm)
	{
		String msg = productserv.addProduct(pm);
		ResponseEntity<String> rentity = new ResponseEntity<>(msg, HttpStatus.CREATED);
		return rentity;
	}
	@PutMapping("/product/{id}")
	ResponseEntity<String> updateProduct(@Valid @RequestBody ProductModel pm,@PathVariable("id") int product_ID)
	{
	
		String msg = productserv.updateProduct(pm, product_ID);
		ResponseEntity<String> rentity = new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
		return rentity;
	}
	@DeleteMapping("/product/{id}")
	ResponseEntity<String> deleteTrainee(@PathVariable("id") int product_ID)
	{
		
		String msg = productserv.deleteProduct(product_ID);
		ResponseEntity<String> rentity = new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
		return rentity;
	}
	
	@GetMapping("/products/{id}/{name}")
	ProductModel getProductByIdAndName(@PathVariable("id") int product_ID, @PathVariable("name") String product_name)
	{
		
		return productserv.getProductByIdAndName(product_ID, product_name);
	}
//	@GetMapping("/products/pname/{name}")
//	ProductModel getProductByName(@PathVariable("name") String pname)
//	{
//		
//		return productserv.getProductByName(pname);
//	}
	
}
