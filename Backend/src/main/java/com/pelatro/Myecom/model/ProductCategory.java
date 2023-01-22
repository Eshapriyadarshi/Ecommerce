package com.pelatro.Myecom.model;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_category")
public class ProductCategory{
		@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", name=" + name + ", products=" + products + "]";
	}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long categoryId;
		
		@Column(name = "name", nullable=false)
		private String name;
		
		@OneToMany(mappedBy="category")
		@JsonIgnore
	    private Set<Product> products;
		

		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}

		public long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(long categoryId) {
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

}
		
        
