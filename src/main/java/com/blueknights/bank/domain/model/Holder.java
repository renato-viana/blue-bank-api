package com.blueknights.bank.domain.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Holder {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;	

	@OneToMany(mappedBy = "holder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Account> accounts;

}
