package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="UTILITY")
public class UserUtility {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d5IMG",columnDefinition="mediumblob")
    public byte[] d5image;
    
    @Column(name="d5IMAGENAME")
    public String d5imagename;
    
    @Column(name="d5STATUS")
    public String d5status;
    
    @Column(name="d5UDATE")
    public String d5udate;
    
    @Column(name="d5EDATE")
    public String d5edate;
    
    @Column(name="d5DOCNAME")
    public String d5docname;

    public UserUtility(String pan,byte[] d5image,String d5imagename,String d5status,String d5udate,String d5edate,String d5docname)
    {this.pan=pan;
    this.d5imagename=d5imagename;
    this.d5status=d5status;
    this.d5udate=d5udate;
    this.d5edate=d5edate;
    this.d5docname=d5docname;
    }
    
    public UserUtility()
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

	public byte[] getd5image() {
		return d5image;
	}

	public void setd5image(byte[] d5image) {
		this.d5image = d5image;
	}

	public String getd5imagename() {
		return d5imagename;
	}

	public void setd5imagename(String d5imagename) {
		this.d5imagename = d5imagename;
	}

	public String getd5status() {
		return d5status;
	}

	public void setd5status(String d5status) {
		this.d5status = d5status;
	}

	public String getd5udate() {
		return d5udate;
	}

	public void setd5udate(String d5udate) {
		this.d5udate = d5udate;
	}

	public String getd5edate() {
		return d5edate;
	}

	public void setd5edate(String d5edate) {
		this.d5edate = d5edate;
	}

	public String getd5docname() {
		return d5docname;
	}

	public void setd5docname(String d5docname) {
		this.d5docname = d5docname;
	}
 
}
