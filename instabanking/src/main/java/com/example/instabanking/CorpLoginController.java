package com.example.instabanking;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CorpLoginController {
	
@RequestMapping(value="/corplogin",method=RequestMethod.GET)
public String init()
{return "corplogin";}
	
@RequestMapping(value="/corplogin",method=RequestMethod.POST) 
public String login(@RequestParam("userid") String userid,@RequestParam("password") String password,Model model)
{
	
	if(!((userid.equals("corp"))||(password.equals("hello123"))))
			{String message="You have entered credentials";
			model.addAttribute("message",message);
			return "corplogin";
			}
	else
	{	model.addAttribute("message","corp");
		return "corpchoice";}
}
}


