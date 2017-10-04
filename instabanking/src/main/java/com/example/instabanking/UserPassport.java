package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="PASSPORT")
public class UserPassport {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d4IMG",columnDefinition="mediumblob")
    public byte[] d4image;
    
    @Column(name="d4IMAGENAME")
    public String d4imagename;
    
    @Column(name="d4STATUS")
    public String d4status;
    
    @Column(name="d4UDATE")
    public String d4udate;
    
    @Column(name="d4EDATE")
    public String d4edate;
    
    @Column(name="d4DOCNAME")
    public String d4docname;

    public UserPassport(String pan,byte[] d4image,String d4imagename,String d4status,String d4udate,String d4edate,String d4docname)
    {this.pan=pan;
    this.d4imagename=d4imagename;
    this.d4status=d4status;
    this.d4udate=d4udate;
    this.d4edate=d4edate;
    this.d4docname=d4docname;
    }
    
    public UserPassport()
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

	public byte[] getd4image() {
		return d4image;
	}

	public void setd4image(byte[] d4image) {
		this.d4image = d4image;
	}

	public String getd4imagename() {
		return d4imagename;
	}

	public void setd4imagename(String d4imagename) {
		this.d4imagename = d4imagename;
	}

	public String getd4status() {
		return d4status;
	}

	public void setd4status(String d4status) {
		this.d4status = d4status;
	}

	public String getd4udate() {
		return d4udate;
	}

	public void setd4udate(String d4udate) {
		this.d4udate = d4udate;
	}

	public String getd4edate() {
		return d4edate;
	}

	public void setd4edate(String d4edate) {
		this.d4edate = d4edate;
	}

	public String getd4docname() {
		return d4docname;
	}

	public void setd4docname(String d4docname) {
		this.d4docname = d4docname;
	}
 
}