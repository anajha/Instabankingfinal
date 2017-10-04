package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="DRIVING")
public class UserDriving {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d6IMG",columnDefinition="mediumblob")
    public byte[] d6image;
    
    @Column(name="d6IMAGENAME")
    public String d6imagename;
    
    @Column(name="d6STATUS")
    public String d6status;
    
    @Column(name="d6UDATE")
    public String d6udate;
    
    @Column(name="d6EDATE")
    public String d6edate;
    
    @Column(name="d6DOCNAME")
    public String d6docname;

    public UserDriving(String pan,byte[] d6image,String d6imagename,String d6status,String d6udate,String d6edate,String d6docname)
    {this.pan=pan;
    this.d6imagename=d6imagename;
    this.d6status=d6status;
    this.d6udate=d6udate;
    this.d6edate=d6edate;
    this.d6docname=d6docname;
    }
    
    public UserDriving()
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

	public byte[] getd6image() {
		return d6image;
	}

	public void setd6image(byte[] d6image) {
		this.d6image = d6image;
	}

	public String getd6imagename() {
		return d6imagename;
	}

	public void setd6imagename(String d6imagename) {
		this.d6imagename = d6imagename;
	}

	public String getd6status() {
		return d6status;
	}

	public void setd6status(String d6status) {
		this.d6status = d6status;
	}

	public String getd6udate() {
		return d6udate;
	}

	public void setd6udate(String d6udate) {
		this.d6udate = d6udate;
	}

	public String getd6edate() {
		return d6edate;
	}

	public void setd6edate(String d6edate) {
		this.d6edate = d6edate;
	}

	public String getd6docname() {
		return d6docname;
	}

	public void setd6docname(String d6docname) {
		this.d6docname = d6docname;
	}
    
}