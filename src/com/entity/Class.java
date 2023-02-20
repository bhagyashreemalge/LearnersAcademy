package com.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany
	@JoinTable(name = "class_subject", joinColumns = @JoinColumn(name = "classes_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subject> subjects=new HashSet<>();
	@OneToMany
	@JoinTable(name = "class_teacher", joinColumns = @JoinColumn(name = "classes_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Teacher> teacher = new HashSet<>();



	public Class() {
		// TODO Auto-generated constructor stub
	}

	public Class(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Class(int id, String name, Set<Subject> subjects, Set<Teacher> teacher) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.teacher = teacher;
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

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}



	
	

}
