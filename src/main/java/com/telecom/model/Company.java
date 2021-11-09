package com.telecom.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.ToString;

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
}
