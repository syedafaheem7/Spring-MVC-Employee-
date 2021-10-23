package com.cuny.queenscollege.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cuny.queenscollege.entity.Employee;
import com.cuny.queenscollege.service.IEmployeeService;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;  //has a 
	
	/***
	 * If End user enters /register in addressbar
	 * this method is called and loads 
	 * EmployeeRegister.html page from /template folder
	 */
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	/**
	 * On Form Submit (/save+POST), Read data as Object using @ModelAttribute
	 * Call service layer with object, read ID back
	 * Create message as String
	 * use Model memory, send message to UI
	 * Return back to EmployeeRegister.html
	 * @throws IOException 
	 */
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute Employee employee,
			Model model) throws IOException 
	{
		
		Integer id = service.saveEmployee(employee);
		String message = "Employee '"+id+"' Created";
		model.addAttribute("message", message);
		return "EmployeeRegister";
	}
	/****
	 * Fetch data from DB using service
	 * send data to UI using Model
	 * Return to EmployeeData.html
	 */
	@GetMapping("/all")
	public String viewAllEmployees(
			@RequestParam(required = false)String message,Model model)
	{
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		model.addAttribute("message",message);
		return "EmployeeData";
	}
	
	/***
	 * Read id from Request URL
	 * call service for delete
	 * get latest data
	 * create success message
	 * send data to UI using Model
	 * return back to EmployeeData.html
	 */
	@GetMapping("/delete")
	public String deleteEmployee(
			@RequestParam Integer id,
			Model model
			) 
	{
		//call service
		service.deleteEmployee(id);
		//one success message
		String message = "Employee '"+id+"' Deleted";
		model.addAttribute("message", message);
		
		//get latest data
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}

	/**
	 * show edit
	 * read id from request param
	 * load DB row using findById
	 * send object to UI using Model
	 * use Thymeleaf Form Reads data from Object and fill it
	 */
	@GetMapping("/edit")
	public String showEmployeeEdit(
			@RequestParam Integer id,
			Model model
			) 
	{
		//load object from DB
		Employee employee = service.getOneEmployee(id);
		//send object to UI
		model.addAttribute("employee", employee);
		//return to View page
		return "EmployeeEdit";
	}
	
	/**
	 * do update
	 * Read Form Data from Edit page
	 * call service
	 * redirect back to all
	 * 
	 */
	@PostMapping("/update")
	public String updateEmployee(
			@ModelAttribute Employee employee,
			RedirectAttributes attributes
			) 
	{
		service.updateEmployee(employee);
		attributes.addAttribute("message", "Employee '"+employee.getId()+"' Updated");
		return "redirect:all";
	
	

}
}
