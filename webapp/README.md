# web-app
# 👩‍💼 Gestion RH des employés

Cette application web, conçue avec **Java Spring Boot**, permet de gérer les employés d'une entreprise : affichage, ajout, modification et suppression.

## 🚀 Démo

_La démo sera bientôt disponible._

## 📦 Fonctionnalités

- ✅ Affichage de la liste des employés
- ✅ Ajout, modification et suppression d’un employé
- 🚧 Génération et modification de mot de passe (fonctionnalité à venir)

## 🛠️ Technologies utilisées

- **Langage** : Java, HTML, CSS
- **Framework** : Spring Boot
- **Base de données** : H2
- **Outils** : Maven/Gradle, Docker, Git, Thymeleaf

## 📂 Structure du projet

```bash
webapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/openclassrooms/webapp/
│   │   │       ├── WebappApplication.java
│   │   │       ├── controller/
│   │   │       │   └── EmployeeController.java
│   │   │       ├── model/
│   │   │       │   └── Employee.java
│   │   │       ├── repository/
│   │   │       │   ├── CustomProperties.java
│   │   │       │   └── EmployeeProxy.java
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
git clone https://github.com/azaLiza/web-app.git
cd gestion-rh-employes

# Lancer l'application
./mvnw spring-boot:run



