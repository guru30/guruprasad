package com.niit.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
@Component
public class Product implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id

	private String product_Id;

	private String product_Name;
	private String description;
	private int product_Price;
	private int product_Stock;
	
	private String supplier_Name;
	
	
	private String category;
	

	@Transient
	private MultipartFile itemImage;


	public String getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}


	public String getProduct_Name() {
		return product_Name;
	}


	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getProduct_Price() {
		return product_Price;
	}


	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}


	public int getProduct_Stock() {
		return product_Stock;
	}


	public void setProduct_Stock(int product_Stock) {
		this.product_Stock = product_Stock;
	}


	public String getSupplier_Name() {
		return supplier_Name;
	}


	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public MultipartFile getItemImage() {
		return itemImage;
	}


	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


	
	
	
	}