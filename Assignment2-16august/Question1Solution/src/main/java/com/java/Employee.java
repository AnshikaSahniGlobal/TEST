package com.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Employee {

	 @RequestMapping("/employee")
	 public String displayEmployee(@RequestParam("employNo") String employNo,@RequestParam("employName") String employName,@RequestParam("designation") String designation, @RequestParam("salary") String salary, Model m){
		 
		  m.addAttribute("emp_number", employNo);
	      m.addAttribute("emp_name", employName);
	      m.addAttribute("designation", designation);
	      m.addAttribute("salary", salary);

		  return "viewpage";
	  }

}
