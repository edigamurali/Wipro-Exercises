package com.wipro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {
	
	@GetMapping("/show")
	public String showData(Model model)
	{
		model.addAttribute("name","murali");
		return"index";
	}

}
