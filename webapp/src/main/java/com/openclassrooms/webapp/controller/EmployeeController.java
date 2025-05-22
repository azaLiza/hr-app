/**
 * 
 */
package com.openclassrooms.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.webapp.model.Employee;
import com.openclassrooms.webapp.service.EmployeeService;

/**
 * 
 */
@Controller
public class EmployeeController {
	
	
	  @Autowired
	  private EmployeeService service;

	@GetMapping("/")
	public String home(Model model) {
	    Iterable<Employee> listEmployee = service.getEmployees();
	    model.addAttribute("employees", listEmployee);
	 // Correspond au nom du fichier html
	    return "home";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
	    service.deleteEmployee(id);
	    return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	    service.saveEmployee(employee);
	    return new ModelAndView("redirect:/");
	}
		
	
	@GetMapping("/createEmployee")
	public String createEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "formNewEmployee";
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") final int id, Model model) {
		Employee e = service.getEmployee(id);		
		model.addAttribute("employee", e);	
		return "formUpdateEmployee";	
		//return new ModelAndView("redirect:/");
	}
	
	
	
}
