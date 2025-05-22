package com.openclassrooms.api.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Récupère tous les employés
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    // Sauvegarde un employé
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
 // Sauvegarde un employé
    //public Employee createEmployee(Employee employee) {
        //return employeeRepository.create(employee);
   // }
    

    // Récupère un employé par son id
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }
    
    // Récupère un employé par sa date de naissance 
    public List<Employee> getEmployee(LocalDate date) {
    	return employeeRepository.findByBirthDate(date);
    }

    // Récupère les employés nés dans le mois
    public List<Employee> getEmployeeBornInMonth(int month) {
    	return employeeRepository.findByBirthMonth(month);
    }
    
    // Supprime un employé par son id
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    /**
     * Recupere les anniversaire de la semaine en modifiant les année de naissance pour pouvoir comparer les date
     *  avec le mois et le jour uniquement sans prendre en compte l'annee
     * @return
     */
    // Recup les employees dont l'anniv est la semaine courante
    public List<Employee> birthdaysOfthisWeek() {
    	
    	LocalDate today = LocalDate.now();
    	LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
    	LocalDate endOfWeek = today.with(DayOfWeek.SUNDAY);
    	
    	
    	return ((Collection<Employee>) employeeRepository.findAll()).stream()
    			.filter( e -> {
    				
    				// Pour chaque employee on recupere la date de naissance
    				LocalDate birthDate = e.getBirthDate();
    				
    				if (birthDate == null) return false;
    				
    				// Sinon on change l'annee de la date de naissance a l'année d'auj pour pouvoir comparer le mois et le jour
    				LocalDate birthDateThisYear = birthDate.withYear(today.getYear());
    				// Recuperer le jour de l'anniversaire de l'employee pour le comparer a aujourd'hui et voir si c'est dans la semaine
    				DayOfWeek birthDay = birthDateThisYear.getDayOfWeek();
    				
    				// Si l'anniversaire est dans la semaine on garde l'employee dans la liste sinon on le jette
    				
    			return !birthDateThisYear.isBefore(startOfWeek) && !birthDateThisYear.isAfter(endOfWeek);
    			})
    			.collect(Collectors.toList());
    }  
}

