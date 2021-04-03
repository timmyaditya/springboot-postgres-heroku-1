package org.timmyaditya.crudUsingJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//jpa entity
@Entity
@Table(name = "student1")
public class StudentModel {
	
	public StudentModel(String sname, String gender, boolean swim, boolean read, boolean cricket, String city) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.swim = swim;
		this.read = read;
		this.cricket = cricket;
		this.city = city;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="swim")
	private boolean swim;
	
	@Column(name="read")
	private boolean read;
	
	@Column(name="cricket")
	private boolean cricket;
	
	@Column(name="city")
	private String city;
	
	
}
