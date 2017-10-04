package com.example.instabanking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserLoginController {
	
	UserInfo n = new UserInfo();
	@Autowired
	private InfoRepository infoRepository;
	
	String mess="";
	
	String userident="";
	
	Products p = new Products();
	@Autowired
	private ProductsRepository productsRepository;
	
	UserAadhar a= new UserAadhar();
	UserPAN b=new UserPAN();
	UserSalary c=new UserSalary();
	UserPassport d=new UserPassport();
	UserUtility e=new UserUtility();
	UserDriving f=new UserDriving();
	
	String passwordfetched="";
	String aadharrequired="";
	String panrequired="";
	String salaryrequired="";
	String passportrequired="";
	String utilityrequired="";
	String drivingrequired="";
	
	
	String aadharpresent="";
	String panpresent="";
	String salarypresent="";
	String passportpresent="";
	String utilitypresent="";
	String drivingpresent="";
	
	String messagenotpresent="";
	
	String messagepresent="You have all the documents, you can apply by clicking on the below button link";

	
	int count=0;
	
	Integer id=1;
	
	String userid="";
	
	
	
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
	
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public String init()
	{return "userlogin";}
	
	
	
@RequestMapping(value="/userlogin",method=RequestMethod.POST) 
public String login(@RequestParam("pan") String pan,@RequestParam("password") String password,Model model)
{
	try
	{	
		userident=pan;
		n = infoRepository.findBypan(userident);
		passwordfetched=n.getpassword();
		if(passwordfetched.equals(password))
		{	
			
			return "redirect:/useroffer";
		}
		else
		{	
			String msg="You have entered incorrect password";
			model.addAttribute("message",msg);
			return "userlogin";
		}
	}
	catch(Exception e1)
	{	
		String msg="You have entered incorrect PAN";
		model.addAttribute("message",msg);
		return "userlogin";
	}

}

@RequestMapping(value="/useroffer",method=RequestMethod.GET)
public String viewoffer(Model model)
{
	getoffer(model);
	return "useroffer";
}

public void getoffer(Model model)
{
	model.addAttribute("message4",userident);
	messagenotpresent="";
	count=0;
try
{	
	p=productsRepository.findByid(id);
	aadharrequired=p.getAadhar();
	panrequired=p.getPan();		
	salaryrequired=p.getSalary();
	passportrequired=p.getPassport();
	utilityrequired=p.getUtility();
	drivingrequired=p.getDriving();
	model.addAttribute("message",p.getProdname());
	String imagelocation="/images/"+p.getImagename();
	model.addAttribute("message1",imagelocation);
}
catch(Exception e1)
{}


if(aadharrequired.equals("yes"))
{
try
{
	a=aadharRepository.findBypan(userident);
	model.addAttribute("message5",a.getPan());
	
}

catch(Exception e1)
{	
	messagenotpresent=messagenotpresent + "Aadhar, ";
	count=count+1;
}
}

if(panrequired.equals("yes"))
	{
	try
	{
		b=panRepository.findBypan(userident);
		model.addAttribute("message5",b.getPan());
	}
	
	catch(Exception e)
	{	
		messagenotpresent=messagenotpresent + "PAN, ";
		count=count+1;
	}
}

if(salaryrequired.equals("yes"))
{
	try
	{
		c=salaryRepository.findBypan(userident);
		model.addAttribute("message5",c.getPan());
	}
	
	catch(Exception e)
	{	
		messagenotpresent=messagenotpresent + "Salary Slip, ";
		count=count+1;
	}
}

if(passportrequired.equals("yes"))
	{
	try
	{
		d=passportRepository.findBypan(userident);
		model.addAttribute("message5",d.getPan());
	}
	
	catch(Exception e)
	{	
		
		messagenotpresent=messagenotpresent + "Passport, ";
		count=count+1;
	}
}

if(utilityrequired.equals("yes"))
	{
	try
	{	
		e=utilityRepository.findBypan(userident);
		model.addAttribute("message5",e.getPan());
	}
	
	catch(Exception e)
	{	
		
		messagenotpresent=messagenotpresent + "Utility Bill, ";
		count=count+1;
		
	}
}


if(drivingrequired.equals("yes"))
	{
	try
	{
		f=drivingRepository.findBypan(userident);	
		model.addAttribute("message5",f.getPan());
	}
	
	catch(Exception e)
	{	
		messagenotpresent=messagenotpresent + "Driving License";
		count=count+1;
	}
}

if(count!=0)
{model.addAttribute("message2",messagenotpresent);
 model.addAttribute("message3","You can apply for the above offer by providing the above documents.");}
else
{model.addAttribute("message3",messagepresent);
}

}

}





