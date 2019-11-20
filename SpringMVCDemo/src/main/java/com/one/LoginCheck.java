package com.one;  
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;  
@Controller  
public class LoginCheck {  
	
	/*
	 * @RequestMapping("/") public String display() { return "index"; }
	 */     
@RequestMapping("/login")
	public String redirect() {
		
		return "Login";
	}
@RequestMapping("/LoginCheck")
	public String validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String username=request.getParameter("userN");
	System.out.println(username);
	String password=request.getParameter("pass");
	System.out.println(password);
	boolean abc=App.isValid(username, password);
	System.out.println(abc);
	if(abc==true)
		return "success";
	else
		return "error";
}
}