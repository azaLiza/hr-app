/**
 * 
 */
package com.openclassrooms.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassrooms.api.model.Employee;

/**
 * 
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	List<Employee> findByBirthDate(LocalDate date);
	
	// Pour pousser le truc plus loin je veux récuperer les employés par mois de naissance
	@Query(value = "SELECT * FROM employee WHERE MONTH(birth_date) =  :month", nativeQuery = true)
	List<Employee> findByBirthMonth(@Param("month") int month);
	
	// Pour la methode get employees dont l'anniversaire est cette semain vu que c'est compliqué de comparer en sql le moi et le jour sans l'année
	// j'utilise findall et je filtre directement dans les resultats dans employeeService

}
