package net.javaguides.springboot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "employees")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
}
