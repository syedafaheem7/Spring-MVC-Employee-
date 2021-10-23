package com.cuny.queenscollege.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emptab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer id;

	@Column(name = "ename")
	private String empName;

	@Column(name = "esal")
	private Double empSal;

	@Column(name = "edept")
	private String empDept;

	@Column(name = "eaddr")
	private String empAddr;

}
