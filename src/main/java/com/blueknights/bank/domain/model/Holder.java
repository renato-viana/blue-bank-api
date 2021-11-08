package com.blueknights.bank.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

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
	private String cpf;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;
	
	@Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    private OffsetDateTime creationDate;

	@OneToMany(mappedBy = "holder")
	private List<Account> accounts;

}
