package com.example.product.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.exception.ProductIdAndNameNotFoundException;
import com.example.product.exception.ProductIdNotFoundException;
import com.example.product.model.ProductModel;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productrepo;
	public List<ProductModel> getAll()
	{
		return productrepo.findAll();
	}
	
	
	public String addProduct(ProductModel pm)
	{
		ProductModel p = productrepo.save(pm);
		 if(p!=null)
			 return "Product Added Successfully!!!";
		 else
			 return "Problem in inserting";
	}
	
	public String updateProduct(ProductModel pm,int product_ID)
	{
		
		Optional<ProductModel> op= productrepo.findById(product_ID);
		if(op.isPresent())
		{
			productrepo.save(pm);
			return "Product Updated Successfully!!!";
		}
			
		else
			throw new ProductIdNotFoundException("No record found for requested Product Id"+product_ID);
	}
	
	public String deleteProduct(int product_ID)
	{
		
		Optional<ProductModel> op= productrepo.findById(product_ID);
		if(op.isPresent())
		{
			productrepo.deleteById(product_ID);
			return "Product deleted Successfully!!!";
		}
			
		else
			throw new ProductIdNotFoundException("No record found for requested Product Id: "+product_ID);
	}
	
	

	public ProductModel getProductByIdAndName(int product_ID, String product_name )
	{
		
		Optional<ProductModel> op= productrepo.getByIdAndName(product_ID, product_name);
		if(op.isPresent())
			return op.get();
		else
			throw new ProductIdAndNameNotFoundException("No record found for requested Product Id: "+product_ID+" and Name: "+product_name);
	}
//	public ProductModel getProductByName(String pname)
//	{
//		
//		Optional<ProductModel> op= productrepo.findByProduct_name(pname);
//		if(op.isPresent())
//			return op.get();
//		else
//			throw new ProductNameNotFoundException("No record found for requested Product Name"+pname);
//	}
}
