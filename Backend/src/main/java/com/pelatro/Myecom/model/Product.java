package com.pelatro.Myecom.model;



import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "product")
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name="description", nullable=false, length=50000)
	private String description;
	
	@Column(name="price", nullable=false)
	private double	 price;
	
	@Column(name="brand", nullable=false)
    private String brand;
	
	@Column(name="image_url", nullable=false, length=600000)
	private String imageUrl;
	
	@Column(name="quantity", nullable=false)
	private long quantity;
	
    @ManyToOne(optional = false)
    @JoinColumn(name="category_id", nullable=true)
    private ProductCategory category;
    
    @OneToMany(mappedBy="product")
	@JsonIgnore
    private Set<Cart> cart;
    
    
    

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
}
