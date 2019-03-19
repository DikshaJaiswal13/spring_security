package com.pack.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@Controller

public class EditEmployeeController {
	@RequestMapping(value="/list")//invoke listEmployee method
	public String listEmployee(ModelMap m){
		
		List<Employee> l=employeeService.listEmployees();
		m.addAttribute("employee",new Employee());
		m.addAttribute("employeeList",l);
		return "EmployeeList";
		
	}
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee")Employee e)
	{
		employeeService.addEmployee(e);
		return "redirect:/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id")Integer id){
		employeeService.deleteEmployee(id);
		return "redirect:/list";
	}
	@RequestMapping(value="/login")
	public String login(ModelMap m){
		return "login";//goes to viewresolver
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap model){
		return "logout";//goes to viewresolver
	}
	
	
	@RequestMapping(value="/accessdenied",method=RequestMethod.GET)
	public String loginerror(ModelMap model){
		model.addAttribute("error","true");
		return "denied";//goes to viewresolver
	}
	
}
