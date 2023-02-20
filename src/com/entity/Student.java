package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "class_id")
    private Class classes;
	
	
    
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Student(int id, String name, Class classes) {
		super();
		this.id = id;
		this.name = name;
		this.classes = classes;
	}
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Class getClasses() {
		return classes;
	}


	public void setClasses(Class classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classes=" + classes + "]";
	}
}
