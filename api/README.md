# 👩‍💼 API de Gestion RH des employés

Cette API, conçue avec **Java Spring Boot**, permet d'exposer les endpoints nécessaires pour que l'application web puisse intéragir avec la base de données.

## 🚀 Démo

_La démo sera bientôt disponible._

## 📦 Fonctionnalités

- ✅ Affichage de la liste des employés
- ✅ Ajout, modification et suppression d’un employé
- 🚧 Génération et modification de mot de passe (fonctionnalité à venir)

## 🛠️ Technologies utilisées

- **Langage** : Java
- **Framework** : Spring Boot
- **Base de données** : H2
- **Outils** : Maven/Gradle, Docker, Git

## 🛠️ Dépendances principales

- **Spring Boot Starter Web** – pour exposer des endpoints REST.
- **Spring Boot Starter Data JPA** – pour l’interaction avec la base de données via JPA/Hibernate.
- **H2 Database** – base de données embarquée pour les tests et le développement local.
- **Lombok** – pour réduire le code boilerplate (getters/setters, constructeurs…).
- **Spring Boot Starter Tes**t – pour les tests unitaires et d’intégration.




## 📂 Structure du projet

```bash
webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/openclassrooms/api/
│   │   │       ├── WebappApplication.java
│   │   │       ├── controller/
│   │   │       │   └── EmployeeController.java
│   │   │       ├── model/
│   │   │       │   └── Employee.java
│   │   │       ├── repository/
│   │   │       │   └── EmployeeRepository.java
│   │   │       └── service/
│   │   │           └── EmployeeService.java
│   │   └── resources/
│   └── test/java/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── target/
└── HELP.md



## ⚙️ Installation
**Prérequis**
- Java 21+
- Maven ou Gradle
- Docker (optionnel pour l'instant)

## Etapes

# Cloner le dépôt
git clone https://github.com/azaLiza/api.git
cd api

# Lancer l'application
./mvnw spring-boot:run



