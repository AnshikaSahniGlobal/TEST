package com.example.customer.controller;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	
	@RequestMapping("/")
	public String display()
	{
		return "customer.jsp";
	}
	
	 @RequestMapping("/customers")
	 public String displayEmployee(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("phone") String phone, @RequestParam("address") String address,@RequestParam("loginid") String loginid,@RequestParam("password") String password, Model m){
		 
		  m.addAttribute("id", id);
	      m.addAttribute("name", name);
	      m.addAttribute("phone", phone);
	      m.addAttribute("address", address);
	      m.addAttribute("address", address);
	      m.addAttribute("loginid", loginid);
	      m.addAttribute("password", password);
	      

		  return "customerview.jsp";
	  }

	
}
