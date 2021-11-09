package com.telecom.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.ToString;
@Entity
public class Product {
	private @Id @GeneratedValue long id;
	private String image;
	private String name;
	private String brand;
	private Integer quantity;
	private double price;
	private Integer nb_clicks;
	private Integer nb_views;
	private Integer nb_sales;

	@ManyToMany(fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Company> companies;

	public Product(){this.companies=new HashSet<>();}
	public void setPrice(double price1) {
		this.price=price1;

	}
	public void setName(String name1){
		this.name=name1;
	}
	public void setQuantity(Integer quantity1) {
		this.quantity=quantity1;

	}

}
