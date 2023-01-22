package com.example.product.exception;

public class ProductIdAndNameNotFoundException extends RuntimeException {
	public ProductIdAndNameNotFoundException(String message)
	{
		super(message);
	}
}
