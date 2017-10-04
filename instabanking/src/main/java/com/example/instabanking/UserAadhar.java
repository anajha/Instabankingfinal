package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="AADHAR")
public class UserAadhar {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d1IMG",columnDefinition="mediumblob")
    public byte[] d1image;
    
    @Column(name="d1IMAGENAME")
    public String d1imagename;
    
    @Column(name="d1STATUS")
    public String d1status;
    
    @Column(name="d1UDATE")
    public String d1udate;
    
    @Column(name="d1EDATE")
    public String d1edate;
    
    @Column(name="d1DOCNAME")
    public String d1docname;
    
    public UserAadhar(String pan,byte[] d1image,String d1imagename,String d1status,String d1udate,String d1edate,String d1docname)
    {this.pan=pan;
    this.d1imagename=d1imagename;
    this.d1status=d1status;
    this.d1udate=d1udate;
    this.d1edate=d1edate;
    this.d1docname=d1docname;
    }
    
    public UserAadhar()
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

	public byte[] getd1image() {
		return d1image;
	}

	public void setd1image(byte[] d1image) {
		this.d1image = d1image;
	}

	public String getd1imagename() {
		return d1imagename;
	}

	public void setd1imagename(String d1imagename) {
		this.d1imagename = d1imagename;
	}

	public String getd1status() {
		return d1status;
	}

	public void setd1status(String d1status) {
		this.d1status = d1status;
	}

	public String getd1udate() {
		return d1udate;
	}

	public void setd1udate(String d1udate) {
		this.d1udate = d1udate;
	}

	public String getd1edate() {
		return d1edate;
	}

	public void setd1edate(String d1edate) {
		this.d1edate = d1edate;
	}

	public String getd1docname() {
		return d1docname;
	}

	public void setd1docname(String d1docname) {
		this.d1docname = d1docname;
	}
	
}
    
    