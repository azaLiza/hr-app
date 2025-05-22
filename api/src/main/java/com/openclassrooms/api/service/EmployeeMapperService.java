/**
 * 
 */
package com.openclassrooms.api.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Employee;

import dto.EmployeeDTO;

/**
 * 
 */
@Service
public class EmployeeMapperService {
	

	public static EmployeeDTO toDTO(Employee employee) {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setFirstname(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		// On modifie l'annee de naissance pour afficher l'anniversaire
		dto.setBirthDate(employee.getBirthDate().withYear(LocalDate.now().getYear()));
		dto.setAge(Period.between(employee.getBirthDate(), LocalDate.now()).getYears());
		
		return dto;
	}

}
