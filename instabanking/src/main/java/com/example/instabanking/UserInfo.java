package com.example.instabanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class

@Table(name="USERINFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    public Integer id;
    
    @Column(name="PAN")
    public String pan;
    
    @Column(name="NAME")
    public String name;
    
    @Column(name="MAILID")
    public String mailid;
    
    @Column(name="PASSWORD")
    public String password;
    
    public UserInfo(String pan,String name,String mailid,String password)
    {
    this.pan=pan;
    this.name=name;
    this.mailid=mailid;
    this.password=password;
    }
    public UserInfo()
    {}
    
    public String getpan() {
		return pan;
	}

	public void setpan(String pan) {
		this.pan = pan;
	}
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public String getmailid() {
		return mailid;
	}

	public void setmailid(String mailid) {
		this.mailid = mailid;
	}
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}