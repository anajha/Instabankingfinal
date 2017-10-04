package com.example.instabanking;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CorpDockCheckController {
	
	String userid=""; 
	
	UserInfo n = new UserInfo();
	UserAadhar a= new UserAadhar();
	UserPAN b=new UserPAN();
	UserSalary c=new UserSalary();
	UserPassport d=new UserPassport();
	UserUtility e=new UserUtility();
	UserDriving f=new UserDriving();

	
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
	
	@Autowired
	private InfoRepository infoRepository;
	
	@RequestMapping(value="/corpuserselect",method=RequestMethod.GET)
	public String init()
	{return "corpuserselect";}
	
	@RequestMapping(value="/corpuserselect",method=RequestMethod.POST)
	public String disp(@RequestParam("pan") String pan,Model model)
	{
		
		try
		{	
			userid=pan;
			n = infoRepository.findBypan(userid);
			if(n.getpan().equals(pan))
			{
				return "redirect:/corpdoccheck";
			}
			else
			{
			  return "corpuserselect";
			}
		}
		
		catch(Exception e)
		
		{ 
			model.addAttribute("message","You seem to have entered an invalid PAN. Please enter correct credentials:-");
			return "corpuserselect";
		}
		
	}
	
	@RequestMapping(value="/corpdoccheck",method=RequestMethod.GET)
	public String viewdoc(Model model)
	{
		viewdocs(model);
		model.addAttribute("messagepan",userid);
		return "corpdoccheck";
	}
		
	public void viewdocs(Model model)
	{	
		model.addAttribute("messagepan",userid);
		List<UserAadhar> a1=aadharRepository.findAll();
		 for(UserAadhar a2:a1)
		 {
			 if(a2.getPan().equals(userid))
			 {model.addAttribute("aadhar",a2);}
		 }
		 
		 List<UserPAN> b1=panRepository.findAll();
		 for(UserPAN b2:b1)
		 {
			 if(b2.getPan().equals(userid))
			 {model.addAttribute("pan",b2);}
		 }
		 
		 List<UserSalary> c1=salaryRepository.findAll();
		 for(UserSalary c2:c1)
		 {
			 if(c2.getPan().equals(userid))
			 {model.addAttribute("salary",c2);}
		 }
		 
		 List<UserPassport> d1=passportRepository.findAll();
		 for(UserPassport d2:d1)
		 {
			 if(d2.getPan().equals(userid))
			 {model.addAttribute("passport",d2);}
		 }
		 
		 List<UserUtility> e1=utilityRepository.findAll();
		 for(UserUtility e2:e1)
		 {
			 if(e2.getPan().equals(userid))
			 {model.addAttribute("utility",e2);}
		 }
		 
		 List<UserDriving> f1=drivingRepository.findAll();
		 for(UserDriving f2:f1)
		 {
			 if(f2.getPan().equals(userid))
			 {model.addAttribute("driving",f2);}
		 }
		 
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d1") 
public String expiryaadhar(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		a=aadharRepository.findBypan(userid);
		a.setd1edate(eday);
		aadharRepository.save(a);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}

@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d2") 
public String expirypan(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{
		userid=pan;
		b=panRepository.findBypan(userid);
		b.setd2edate(eday);
		panRepository.save(b);

	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d3") 
public String expirysalary(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		c=salaryRepository.findBypan(userid);
		c.setd3edate(eday);
		salaryRepository.save(c);
		
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d4") 
public String expirypassport(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{
		userid=pan;
		d=passportRepository.findBypan(userid);
		d.setd4edate(eday);
		passportRepository.save(d);
		
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d5") 
public String expiryutility(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		e=utilityRepository.findBypan(userid);
		e.setd5edate(eday);
		utilityRepository.save(e);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d6") 
public String expirydriving(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		f=drivingRepository.findBypan(userid);
		f.setd6edate(eday);
		drivingRepository.save(f);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","The expiry date has been successfully set");
	return "corpdoccheck";
}

@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d1doc") 
public String updateaadhar(@RequestParam("pan") String pan,Model model)
{
	try
	{
		userid=pan;
		a=aadharRepository.findBypan(userid);
		a.setd1status("Verified");
		aadharRepository.save(a);
		
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","Aadhar document has been successfully verified");
	return "corpdoccheck";
}

@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d2doc") 
public String updatepan(@RequestParam("pan") String pan,Model model)
{
	try
	{	
		userid=pan;
		b=panRepository.findBypan(userid);
		b.setd2status("Verified");
		panRepository.save(b);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","PAN has been successfully verified");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d3doc") 
public String updatesalary(@RequestParam("pan") String pan,Model model)
{
	try
	{	
		userid=pan;
		c=salaryRepository.findBypan(userid);
		c.setd3status("Verified");
		salaryRepository.save(c);
		
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","Salary slip has been successfully verified");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d4doc") 
public String updatepassport(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		d=passportRepository.findBypan(userid);
		d.setd4status("Verified");
		passportRepository.save(d);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","Passport has been successfully verified");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d5doc") 
public String updateutility(@RequestParam("pan") String pan,@RequestParam("eday") String eday,Model model)
{
	try
	{	
		userid=pan;
		e=utilityRepository.findBypan(userid);
		e.setd5status("Verified");
		utilityRepository.save(e);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","Utility bill has been successfully verified");
	return "corpdoccheck";
}
@RequestMapping(value="/corpdoccheck",method=RequestMethod.POST,params="d6doc") 
public String updatedriving(@RequestParam("pan") String pan,Model model)
{
	try
	{	
		userid=pan;
		f=drivingRepository.findBypan(userid);
		f.setd6status("Verified");
		drivingRepository.save(f);
	}
	catch(Exception e1)
	{}
	viewdocs(model);
	model.addAttribute("message1","Driving license has been successfully verified");
	return "corpdoccheck";
}
}



