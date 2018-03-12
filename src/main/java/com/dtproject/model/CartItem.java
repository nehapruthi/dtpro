package com.dtproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int cartItem_id;
	
	private int cartId;
	private int productId;
	private double productprice;
	private int quantity;
	
	private int billingAddress;
	private int shippingAddress;
	
	public int getCartItem_id() {
		return cartItem_id;
	}
	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(int billingAddress) {
		this.billingAddress = billingAddress;
	}
	public int getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(int shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
