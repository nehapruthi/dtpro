package com.dtproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int pId;
	
	private String pName;
	private int pQuantity;
	private float pPrice;
	private String pDescription;
	private String pImg;
	
	@Transient
	private MultipartFile pFile;
	
	@OneToOne(targetEntity=Category.class) 
	@JoinColumn(name="categoryId",referencedColumnName="cId")
	Category category;
	
	@OneToOne(targetEntity=Supplier.class)
	@JoinColumn(name="supplierId",referencedColumnName="sId")
	private Supplier supplier;

	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
