package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="PAN")
public class UserPAN {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Lob
    @Column(name="d2IMG",columnDefinition="mediumblob")
    public byte[] d2image;
    
    @Column(name="d2IMAGENAME")
    public String d2imagename;
    
    @Column(name="d2STATUS")
    public String d2status;
    
    @Column(name="d2UDATE")
    public String d2udate;
    
    @Column(name="d2EDATE")
    public String d2edate;
    
    @Column(name="d2DOCNAME")
    public String d2docname;

    public UserPAN(String pan,byte[] d2image,String d2imagename,String d2status,String d2udate,String d2edate,String d2docname)
    {this.pan=pan;
    this.d2imagename=d2imagename;
    this.d2status=d2status;
    this.d2udate=d2udate;
    this.d2edate=d2edate;
    this.d2docname=d2docname;
    }
    
    public UserPAN()
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

	public byte[] getd2image() {
		return d2image;
	}

	public void setd2image(byte[] d2image) {
		this.d2image = d2image;
	}

	public String getd2imagename() {
		return d2imagename;
	}

	public void setd2imagename(String d2imagename) {
		this.d2imagename = d2imagename;
	}

	public String getd2status() {
		return d2status;
	}

	public void setd2status(String d2status) {
		this.d2status = d2status;
	}

	public String getd2udate() {
		return d2udate;
	}

	public void setd2udate(String d2udate) {
		this.d2udate = d2udate;
	}

	public String getd2edate() {
		return d2edate;
	}

	public void setd2edate(String d2edate) {
		this.d2edate = d2edate;
	}

	public String getd2docname() {
		return d2docname;
	}

	public void setd2docname(String d2docname) {
		this.d2docname = d2docname;
	}

}
