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
public class CorpOfferUpdateController {
	
	
	private static String UPLOADED_FOLDER = "D:\\Users\\anajha\\Desktop\\Hackathon\\instabanking\\src\\main\\resources\\static\\images\\";
	Products p = new Products();
	@Autowired
	private ProductsRepository productsRepository;
	@RequestMapping(value="/corpofferupdate",method=RequestMethod.GET)
	public String init()
	{return "corpofferupdate";}
	

@RequestMapping(value="/corpofferupdate",method=RequestMethod.POST) 
public String process(@RequestParam("offername") String offername,@RequestParam("filed1") MultipartFile file,@RequestParam(value="aadhar",defaultValue="false") String aadhar,@RequestParam(value="pan",defaultValue="false") String pan,@RequestParam(value="salary",defaultValue="false") String salary,@RequestParam(value="passport",defaultValue="false") String passport,@RequestParam(value="utility",defaultValue="false") String utility,@RequestParam(value="driving",defaultValue="false") String driving,Model model)
{
	
	p=productsRepository.findByid(1);
	
	p.setProdname(offername);
	try
	{
	byte[] bytes = file.getBytes();
    Path path = Paths.get(UPLOADED_FOLDER +offername+file.getOriginalFilename());
    String imgname=offername+file.getOriginalFilename();
    Files.write(path, bytes);
    p.getImage();
    p.setImage(bytes);
    p.getImagename();
    p.setImagename(imgname);
	}
	catch(IOException e)
	{}

	if(aadhar.equals("false"))
	{p.setAadhar("no");;
	}
	else
	{
		p.setAadhar("yes");}
	
	if(pan.equals("false"))
	{p.setPan("no");
	}
	else
	{	
		p.setPan("yes");}
	
	
	if(salary.equals("false"))
	{p.setSalary("no");
	}
	else
	{	
		
		p.setSalary("yes");
	}
	
	
	if(passport.equals("false"))
	{p.setPassport("no");
	}
	else
	{	
		
		p.setPassport("yes");}
	
	
	if(utility.equals("false"))
	{p.setUtility("no");
	}
	else
	{	
		p.setUtility("yes");}
	
	
	if(driving.equals("false"))
	{p.setDriving("no");
	}
	else
	{	
		p.setDriving("yes");}
	
	productsRepository.save(p);
	
	
	model.addAttribute("message","Product information has been successfully uploaded");
	
	return "corpofferupdate";
	
}
}


