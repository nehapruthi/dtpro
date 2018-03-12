package com.dtproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int uId;
		
	@NotNull(message="Username is null")
	@NotEmpty(message="Username is empty")
	private String uName;
	
	@NotNull(message="Email is null")
	@NotEmpty(message="Email is empty")
	private String email;
	
	@NotNull(message="password is null")
	@NotEmpty(message="password is empty")
	private String password;
	
	@NotNull(message="role is null")
	@NotEmpty(message="role is empty")
	private String role;
	
	private int cartId;
	
	@NotNull(message="phone is null")
	@NotEmpty(message="phone is empty")
	private String phone;
	
	private boolean enabled; 
	private String pic;
	
	@NotNull(message="address is null")
	@NotEmpty(message="address is empty")
	private String address;
	
	
	@Transient
	private MultipartFile pFile;
	
	public MultipartFile getpFile() {
		return pFile;
	}
	public void setpFile(MultipartFile pFile) {
		this.pFile = pFile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
