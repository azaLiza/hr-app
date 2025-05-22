/**
 * 
 */
package com.openclassrooms.api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeMapperService;
import com.openclassrooms.api.service.EmployeeService;

import dto.EmployeeDTO;

/**
 * 
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapperService employeeMapper;
	
	/**
	 * Read - get all employees
	 * @return - An Iterable object of employees full filled
	 */
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	/**
	 * Create - Add a new employee
	 * @param employee An object employee
	 * @return The employee object saved
	 */
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	/**
	 * Read - Get one employee 
	 * @param id The id of the employee
	 * @return An Employee object full filled
	 */
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") final Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Exemple d'appel api sur postman : GET /employees/birthdate?date=1990-05-20
	 * @param date
	 * @return
	 */
	@GetMapping("employee/birthdate")
	public List<EmployeeDTO> getEmployeesByBirthDate(@RequestParam String date) {
		
		LocalDate birthDate = LocalDate.parse(date); // Au format YYYY-MM-DD
		return employeeService.getEmployee(birthDate).stream()
				.map(EmployeeMapperService::toDTO)
				.collect(Collectors.toList());
	}
	
	/**
	 * Exemple d'appel API sur postman GET /employees/birthmonth?month=5
	 * @param month
	 * @return
	 */
	@GetMapping("employee/birthmonth")
	public List<EmployeeDTO> getEmployeesByBirthMonth(@RequestParam int month) {
		if(month > 0 && month < 13) {
			return employeeService.getEmployeeBornInMonth(month).stream()
					.map(EmployeeMapperService::toDTO)
					.collect(Collectors.toList());
		} else {
			// Throw exception ?
			return null;
		}
	}
	
	/**
	 * Pour tester l'api sur postman ex : GET /employees/birthday-this-week
	 * @return
	 */
	@GetMapping("/employees/birthday-this-week")
	public List<EmployeeDTO> getBirthdaysOfThisWeek () {
		
		return employeeService.birthdaysOfthisWeek().stream()
				.map(EmployeeMapperService::toDTO)
				.collect(Collectors.toList());
	}
	
	
	
	/**
	 * Update - Update an existing employee
	 * @param id - The id of the employee to update
	 * @param employee - The employee object updated
	 * @return
	 */
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
		Optional<Employee> e = employeeService.getEmployee(id);
		if(e.isPresent()) {
			Employee currentEmployee = e.get();
			
			String firstName = ((Employee) employee).getFirstName();
			if(firstName != null) {
				currentEmployee.setFirstName(firstName);
			}
			String lastName = employee.getLastName();
			if(lastName != null) {
				currentEmployee.setLastName(lastName);;
			}
			String mail = employee.getMail();
			if(mail != null) {
				currentEmployee.setMail(mail);
			}
			String password = employee.getPassword();
			if(password != null) {
				currentEmployee.setPassword(password);;
			}
			employeeService.saveEmployee(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an employee
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		employeeService.deleteEmployee(id);
	}
	
	
}
