package com.telecom.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
public class Company {
	private @Id @GeneratedValue long id;
	private String name;
	private long budget;
	private LocalDate starting_date;
	private LocalDate ending_date;

	@ManyToMany(fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Product> products;
	@OneToMany(mappedBy = "company",  orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Campaign> campaigns;

	public Company() {
		this.products = new HashSet<Product>();
		this.campaigns = new HashSet<Campaign>();
	}
	public void setBudget(long budget){
		this.budget=budget;
	}

	public void setStartingDate(LocalDate starting_date) {
		this.starting_date = starting_date;
	}

	public void setEndingDate(LocalDate ending_date) {
		this.ending_date = ending_date;
	}

	public void addProduct(Product product) {
		products.add(product);
	}
}

