/**
 * 
 */
package dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * 
 */
@Data
// J'annote avec data pour que lombok utilise ses getters/setters/constructor soient automatiques
public class EmployeeDTO {
	
	// Dans cette class j'ai besoin d'exposer uniquement le prénom, nom et date de naissance de l'employé pour connaître la date de son anniversaire
	private String firstname;
	private String lastName;
	private LocalDate birthDate;
	// TODO IDK IF j'affiche l'age reel ou age+1 ?
	private int age;

}
