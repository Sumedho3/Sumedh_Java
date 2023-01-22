package com.example.product.exception;

public class ProductIdNotFoundException extends RuntimeException{
	public ProductIdNotFoundException(String message)
	{
		super(message);
	}
}
