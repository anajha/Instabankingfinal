package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="PRODUCTS")
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="PRODNAME")
    private String prodname;
    
    @Lob
    @Column(name="PRODIMAGE",columnDefinition="mediumblob")
    private byte[] image;
    
    @Column(name="IMGNAME")
    private String imagename;
    
    @Column(name="AADHAR")
    private String aadhar;
    
    @Column(name="PAN")
    private String pan;
    
    @Column(name="SALARY")
    private String salary;
    
    @Column(name="PASSPORT")
    private String passport;
    
    @Column(name="UTILITY")
    private String utility;
    
    @Column(name="DRIVING")
    private String driving;
    
    public Products(String prodname,byte[] image,String imagname,String aadhar,String pan,String salary,String passport,String utility,String driving)
    {this.prodname=prodname;
    this.image=image;
    this.imagename="imagname";
    this.aadhar=aadhar;
    this.pan=pan;
    this.salary=salary;
    this.passport=passport;
    this.utility=utility;
    this.driving=driving;
    }
    
    public Products()
    {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public String getDriving() {
		return driving;
	}

	public void setDriving(String driving) {
		this.driving = driving;
	}
    
    

}    