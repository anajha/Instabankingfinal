package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="SALARY")
public class UserSalary {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d3IMG",columnDefinition="mediumblob")
    public byte[] d3image;
    
    @Column(name="d3IMAGENAME")
    public String d3imagename;
    
    @Column(name="d3STATUS")
    public String d3status;
    
    @Column(name="d3UDATE")
    public String d3udate;
    
    @Column(name="d3EDATE")
    public String d3edate;
    
    @Column(name="d3DOCNAME")
    public String d3docname;

    public UserSalary(String pan,byte[] d3image,String d3imagename,String d3status,String d3udate,String d3edate,String d3docname)
    {this.pan=pan;
    this.d3imagename=d3imagename;
    this.d3status=d3status;
    this.d3udate=d3udate;
    this.d3edate=d3edate;
    this.d3docname=d3docname;
    }
    
    public UserSalary()
    {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public byte[] getd3image() {
		return d3image;
	}

	public void setd3image(byte[] d3image) {
		this.d3image = d3image;
	}

	public String getd3imagename() {
		return d3imagename;
	}

	public void setd3imagename(String d3imagename) {
		this.d3imagename = d3imagename;
	}

	public String getd3status() {
		return d3status;
	}

	public void setd3status(String d3status) {
		this.d3status = d3status;
	}

	public String getd3udate() {
		return d3udate;
	}

	public void setd3udate(String d3udate) {
		this.d3udate = d3udate;
	}

	public String getd3edate() {
		return d3edate;
	}

	public void setd3edate(String d3edate) {
		this.d3edate = d3edate;
	}

	public String getd3docname() {
		return d3docname;
	}

	public void setd3docname(String d3docname) {
		this.d3docname = d3docname;
	}
 
}

