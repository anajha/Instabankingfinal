package com.example.instabanking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CorpChoiceController {
	@RequestMapping(value="/corpchoice",method=RequestMethod.GET)
	public String init()
	{	
		return "corpchoice";}
	
}


