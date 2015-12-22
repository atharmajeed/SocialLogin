package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

//import org.elasticsearch.common.text.StringText;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
public class Customer {

	private String userName;
	private String password;
	
	@RequestMapping (value="/createPerson")
	public @ResponseBody String createPerson(@RequestParam (name="person")Person person ){
		
		System.out.println("Creating new person.... ");
		
		return new String("createperson.jsp");
	}
	
	
	@RequestMapping (value="/login/{username}")
	public void login(@PathVariable("username") String name){
		
        try {
			String content = new String(Files.readAllBytes(Paths.get("pdf-html.html")));
			//System.out.println("new" + content);
			
			
			OutputStream d = new FileOutputStream("hellopdf.pdf");
					
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	@RequestMapping (value="/sms",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> sendSms(@RequestParam (name="number", defaultValue = "00447552588999") String number ){
		
		String resp = "sdfjksd jf k";
		//resp = SMS.sendSMS("+447552588999","THis is a new message with a URL of http://tes.com", "http://www.facebook.com");
		System.out.println("SMS Sent! " + number);
		User u = new User();
		u.setLocation("lon");
		u.setName("sfds");
		
		return new ResponseEntity<User> (u,HttpStatus.OK);
	}

	
	@RequestMapping (value="/hello/",method = RequestMethod.GET)
	public @ResponseBody String hello(){
		
		System.out.println("Hello Me");
		return new String("Peter" );
	}
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
