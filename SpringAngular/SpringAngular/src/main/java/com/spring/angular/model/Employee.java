package com.spring.angular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Please enter name")
	@Size(min = 2, message = "Name should be atleast 2 characters")
	private String name;
	
	@Email(message = "Please enter valid email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotBlank(message = "Please enter Email")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Please enter your DOJ as dd-mm-yyyy ")
	@JsonFormat(pattern = "dd-mm-yyyy", shape = Shape.STRING)
	private String Doj;	
	
	@NotBlank(message = "Please enter Mobile")
	@Size(min=10,  message = "Enter correct mobile number")
	@Size(max=10)
	@Column(unique = true)
	private String mobile;

	
}
