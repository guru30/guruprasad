package com.niit.project.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name ="PRODUCT")
@Component
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String price;
	private String category_name;
	private String supplier_name;
	private int product_Stock;
	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public String getSupplier_name() {
		return supplier_name;
	}


	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}






	public int getProduct_Stock() {
		return product_Stock;
	}
	
	

	


	public void setProduct_Stock(int product_Stock) {
		this.product_Stock = product_Stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	private String description;
	
	@Transient
	private MultipartFile itemImage;

	
	public MultipartFile getItemImage() {
		return itemImage;
	}
	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}

	@Transient
    @ManyToOne
	@JoinColumn(name = "category_id", updatable = false, insertable = false, nullable = false)
	
    @Autowired
	private Category category;
	
    @Transient
	@ManyToOne
	@JoinColumn(name = "supplier_id", updatable = false, insertable = false, nullable = false)
	
	@Autowired
	private Supplier supplier;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return 0;
	}
	
	

}
