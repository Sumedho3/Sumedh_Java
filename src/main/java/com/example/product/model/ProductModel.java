package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductModel {
	@Id
	@NotNull
	private int product_ID;
	@NotNull
	private String product_name;
	@NotNull
	private String product_desc;
	@NotNull
	private int product_price;
	public ProductModel(){}
	public ProductModel(int product_ID, String product_name, String product_desc, int product_price) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	@Override
	public String toString() {
		return "ProductModel [product_ID=" + product_ID + ", product_name=" + product_name + ", product_desc="
				+ product_desc + ", product_price=" + product_price + "]";
	}
	
	
	

	
}
