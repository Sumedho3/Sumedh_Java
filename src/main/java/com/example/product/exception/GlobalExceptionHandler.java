package com.example.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	ResponseEntity<String> handlingMethod(ProductIdNotFoundException idex)
	{
	//	String m = idex.getLocalizedMessage();
		String msg = idex.getClass()+":  "+idex.getMessage();
		ResponseEntity<String> rentity = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return rentity;
	}
	
	@ExceptionHandler(ProductIdAndNameNotFoundException.class)
	ResponseEntity<String> handlingMethod(ProductIdAndNameNotFoundException idex)
	{
	//	String m = idex.getLocalizedMessage();
		String msg = idex.getClass()+":  "+idex.getMessage();
		ResponseEntity<String> rentity = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return rentity;
	}
	
	@ExceptionHandler(Exception.class)
	String handlingMethod(Exception idex)
	{
		return idex.getClass()+":"+idex.getMessage();
	}
}
