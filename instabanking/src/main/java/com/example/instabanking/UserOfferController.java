package com.example.instabanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserOfferController {

private static String UPLOADED_FOLDER = "D:\\Users\\anajha\\Desktop\\Hackathon\\instabanking\\src\\main\\resources\\static\\images\\";

String userid="";

UserAadhar a= new UserAadhar();
UserPAN b=new UserPAN();
UserSalary c=new UserSalary();
UserPassport d=new UserPassport();
UserUtility e=new UserUtility();
UserDriving f=new UserDriving();

long millis=System.currentTimeMillis();  
java.sql.Date udate=new java.sql.Date(millis);
String dt=udate.toString();

@Autowired
private AadharRepository aadharRepository;

@Autowired
private PANRepository panRepository;

@Autowired
private SalaryRepository salaryRepository;

@Autowired
private PassportRepository passportRepository;

@Autowired
private UtilityRepository utilityRepository;

@Autowired
private DrivingRepository drivingRepository;


@RequestMapping(value="/useroffer",method=RequestMethod.POST,params="upload") 
public String checkdocuments(@RequestParam("pan") String pan,Model model)
{
	userid=pan;
	viewdocuments(model);
	return "redirect:/userdocmaint";
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.GET)
public void viewdocuments(Model model)
{
	try
	{
		a=aadharRepository.findBypan(userid);
		
		model.addAttribute("message1", a.getd1imagename());
		model.addAttribute("message2", a.getd1status());
		model.addAttribute("message3", a.getd1udate());
		
		if(a.getd1status().equals("Uploaded"))
		{
			model.addAttribute("message4", "NA");
		}
		else
		{
			model.addAttribute("message4", a.getd1edate());
		}
		}
		
	catch(Exception e1)
	{
		model.addAttribute("message2", "Not Present");
		model.addAttribute("message3", "NA");
		model.addAttribute("message4", "NA");
		model.addAttribute("message26","download");
	}
		
	try
	{
	b=panRepository.findBypan(userid);
	
	model.addAttribute("message5", b.getd2imagename());
	model.addAttribute("message6", b.getd2status());
	model.addAttribute("message7", b.getd2udate());
	
	if(b.getd2status().equals("Uploaded"))
	{
		model.addAttribute("message8", "NA");
	}
	else
	{
		model.addAttribute("message8", b.getd2edate());
	}
	}
	
catch(Exception e1)
{
	model.addAttribute("message6", "Not Present");
	model.addAttribute("message7", "NA");
	model.addAttribute("message8", "NA");
	model.addAttribute("message27","download");
}
	
	try
	{
	c=salaryRepository.findBypan(userid);
	
	model.addAttribute("message9", c.getd3imagename());
	model.addAttribute("message10", c.getd3status());
	model.addAttribute("message11", c.getd3udate());
	
	if(c.getd3status().equals("Uploaded"))
	{
		model.addAttribute("message12", "NA");
	}
	else
	{
		model.addAttribute("message12", c.getd3edate());
	}
	}
	
catch(Exception e1)
{
	model.addAttribute("message10", "Not Present");
	model.addAttribute("message11", "NA");
	model.addAttribute("message12", "NA");
	model.addAttribute("message28","download");
}
	
	try
	{
	d=passportRepository.findBypan(userid);
	
	model.addAttribute("message13", d.getd4imagename());
	model.addAttribute("message14", d.getd4status());
	model.addAttribute("message15", d.getd4udate());
	
	if(d.getd4status().equals("Uploaded"))
	{
		model.addAttribute("message16", "NA");
	}
	else
	{
		model.addAttribute("message16", d.getd4edate());
	}
	}
	
catch(Exception e1)
{
	model.addAttribute("message14", "Not Present");
	model.addAttribute("message15", "NA");
	model.addAttribute("message16", "NA");
	model.addAttribute("message29","download");
}
	
	try
	{
	e=utilityRepository.findBypan(userid);
	
	model.addAttribute("message17", e.getd5imagename());
	model.addAttribute("message18", e.getd5status());
	model.addAttribute("message19", e.getd5udate());
	
	if(e.getd5status().equals("Uploaded"))
	{
		model.addAttribute("message20", "NA");
	}
	else
	{
		model.addAttribute("message20", e.getd5edate());
	}
	}
	
catch(Exception e1)
{
	model.addAttribute("message18", "Not Present");
	model.addAttribute("message19", "NA");
	model.addAttribute("message20", "NA");
	model.addAttribute("message30","download");
}
	
	try
	{
	f=drivingRepository.findBypan(userid);
	
	model.addAttribute("message21", f.getd6imagename());
	model.addAttribute("message22", f.getd6status());
	model.addAttribute("message23", f.getd6udate());
	
	if(f.getd6status().equals("Uploaded"))
	{
		model.addAttribute("message24", "NA");
	}
	else
	{
		model.addAttribute("message24", a.getd1edate());
	}
	}
	
catch(Exception e1)
{
	model.addAttribute("message22", "Not Present");
	model.addAttribute("message23", "NA");
	model.addAttribute("message24", "NA");
	model.addAttribute("message31","download");
}
	
}
	

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d1") 
public String uploadaadhar(@RequestParam("filed1") MultipartFile file,Model model)
{
	try {
		
		a=aadharRepository.findBypan(userid);
		a.setd1status("Uploaded");
		a.setd1udate(dt);
		a.setd1edate("NA");
		String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        a.setd1image(bytes);
        a.setd1imagename(imagepath+userid+ file.getOriginalFilename());
        aadharRepository.save(a);
    
    } catch (Exception e1) 
	{
    	String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		try
		{
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        String imgname=imagepath+userid+ file.getOriginalFilename();
    	a=new UserAadhar(userid,bytes,imgname,"Uploaded",dt,"NA","Aadhar");
    	
		}
		catch(IOException e11)
		{}
		
    	aadharRepository.save(a);
	}
	
	model.addAttribute("message25","Aadhar document has been sucessfully uploaded");
	viewdocuments(model);
	return "userdocmaint";
	
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d2") 
public String uploadpan(@RequestParam("filed2") MultipartFile file,Model model)
{
try {
		
		b=panRepository.findBypan(userid);
		b.setd2status("Uploaded");
		b.setd2udate(dt);
		b.setd2edate("NA");
		String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        a.setd1image(bytes);
        a.setd1imagename(imagepath+userid+ file.getOriginalFilename());
        panRepository.save(b);
    
    } catch (Exception e1) 
	{
    	String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		try
		{
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        String imgname=imagepath+userid+ file.getOriginalFilename();
    	b=new UserPAN(userid,bytes,imgname,"Uploaded",dt,"NA","PAN");
		}
		catch(IOException e11)
		{}
		
    	panRepository.save(b);
    	
	}
	model.addAttribute("message25","PAN card has been sucessfully uploaded");
	viewdocuments(model);
	return "userdocmaint";
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d3") 
public String uploadsalary(@RequestParam("filed3") MultipartFile file,Model model)
{
	try {
	
	c=salaryRepository.findBypan(userid);
	c.setd3status("Uploaded");
	c.setd3udate(dt);
	c.setd3edate("NA");
	String imagepath="/images/";
	String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
	byte[] bytes = file.getBytes();
    Path path = Paths.get(imagename);
    Files.write(path, bytes);
    c.setd3image(bytes);
    c.setd3imagename(imagepath+userid+ file.getOriginalFilename());
    salaryRepository.save(c);

} catch (Exception e1) 
{
	String imagepath="/images/";
	String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
	try
	{
	byte[] bytes = file.getBytes();
    Path path = Paths.get(imagename);
    Files.write(path, bytes);
    String imgname=imagepath+userid+ file.getOriginalFilename();
	c=new UserSalary(userid,bytes,imgname,"Uploaded",dt,"NA","Salary Slip");
	}
	catch(IOException e11)
	{}
	
	salaryRepository.save(c);
	
}
	model.addAttribute("message25","Salary slip has been sucessfully uploaded");
	viewdocuments(model);
	return "userdocmaint";	
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d4") 
public String uploadpassport(@RequestParam("filed4") MultipartFile file,Model model)
{
	try {
		
		d=passportRepository.findBypan(userid);
		d.setd4status("Uploaded");
		d.setd4udate(dt);
		d.setd4edate("NA");
		String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        d.setd4image(bytes);
        d.setd4imagename(imagepath+userid+ file.getOriginalFilename());
        passportRepository.save(d);
    
    } catch (Exception e1) 
	{
    	String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		try
		{
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        String imgname=imagepath+userid+ file.getOriginalFilename();
    	d=new UserPassport(userid,bytes,imgname,"Uploaded",dt,"NA","Passport");
		}
		catch(IOException e11)
		{}
		
    	passportRepository.save(d);
    	
	}
	model.addAttribute("message25","Passport has been sucessfully uploaded");
	viewdocuments(model);
	return "userdocmaint";
	
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d5") 
public String uploadutility(@RequestParam("filed5") MultipartFile file,Model model)
{
try {
		
		e=utilityRepository.findBypan(userid);
		e.setd5status("Uploaded");
		e.setd5udate(dt);
		e.setd5edate("NA");
		String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        e.setd5image(bytes);
        e.setd5imagename(imagepath+userid+ file.getOriginalFilename());
        utilityRepository.save(e);
    
    } catch (Exception e1) 
	{
    	String imagepath="/images/";
		String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
		try
		{
		byte[] bytes = file.getBytes();
        Path path = Paths.get(imagename);
        Files.write(path, bytes);
        String imgname=imagepath+userid+ file.getOriginalFilename();
    	e=new UserUtility(userid,bytes,imgname,"Uploaded",dt,"NA","Utility");
		}
		catch(IOException e11)
		{}
		
    	utilityRepository.save(e);
    	
	}
	
	model.addAttribute("message25","Utility bill has been sucessfully uploaded");	
	viewdocuments(model);
	return "userdocmaint";
}

@RequestMapping(value="/userdocmaint",method=RequestMethod.POST,params="d6") 
public String uploaddriving(@RequestParam("filed6") MultipartFile file,Model model)
{
	try {
	
	f=drivingRepository.findBypan(userid);
	f.setd6status("Uploaded");
	f.setd6udate(dt);
	f.setd6edate("NA");
	String imagepath="/images/";
	String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
	byte[] bytes = file.getBytes();
    Path path = Paths.get(imagename);
    Files.write(path, bytes);
    f.setd6image(bytes);
    f.setd6imagename(imagepath+userid+ file.getOriginalFilename());
    drivingRepository.save(f);

} catch (Exception e1) 
{
	String imagepath="/images/";
	String imagename=UPLOADED_FOLDER + userid + file.getOriginalFilename();
	try
	{
	byte[] bytes = file.getBytes();
    Path path = Paths.get(imagename);
    Files.write(path, bytes);
    String imgname=imagepath+userid+ file.getOriginalFilename();
	f=new UserDriving(userid,bytes,imgname,"Uploaded",dt,"NA","Driving license");
	}
	catch(IOException e11)
	{}
	
	drivingRepository.save(f);
}
	model.addAttribute("message25","Driving license has been sucessfully uploaded");
	viewdocuments(model);
	return "userdocmaint";	
}
}




