package com.example.librarymanagementsystem.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private double price;
}
