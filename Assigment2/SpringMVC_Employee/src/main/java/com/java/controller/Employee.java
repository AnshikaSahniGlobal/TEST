package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Employee {
	
	 @RequestMapping("/employee")
	 public String displayEmployee(@RequestParam("emp number") String employNo,@RequestParam("emp name") String employName,@RequestParam("designation") String designation, @RequestParam("salary") String salary, Model m){
		 
		  m.addAttribute("emp number", employNo);
	      m.addAttribute("emp name", employName);
	      m.addAttribute("designation", designation);
	      m.addAttribute("salary", salary);

		  return "employeeview";
	  }

	
}
