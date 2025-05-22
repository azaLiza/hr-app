# 💼 App-HR – Application de gestion des employés

## 📌 Description

**App-HR** est une application web de démonstration permettant de gérer les employés d'une entreprise. Elle est composée de deux services principaux :
- **API (Back-end)** : Une API REST développée en Java avec Spring Boot.
- **WebApp (Front-end)** : Une interface web consommant l'API, également développée avec Spring Boot (Thymeleaf ou autre moteur si précisé).

Le tout est orchestré avec **Docker** pour faciliter le déploiement et l'exécution locale.

---

## 🛠️ Technologies utilisées

### API (Back-end)
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- Maven

### WebApp (Front-end)
- Java 17+
- Spring Boot
- Thymeleaf (ou autre si modifié)
- Lombok
- Maven

### Conteneurisation
- Docker
- Docker Compose

---

## 🚀 Objectifs pédagogiques

Ce projet vise à :
- Illustrer l’architecture client-serveur avec Spring Boot.
- Mettre en œuvre une API REST consommée par une interface web.
- Maîtriser l’utilisation de Docker et Docker Compose pour orchestrer des microservices simples.

---

## ⚙️ Installation et exécution locale avec Docker

### 📁 Prérequis

Assurez-vous d’avoir les éléments suivants installés sur votre machine :
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

### ▶️ Lancement de l’application

1. Clonez le projet :

```bash
git clone https://github.com/votre-utilisateur/app-hr.git
cd app-hr
```

2. Lancez les services avec Docker Compose :

```bash
docker-compose up --build
```
Cela va :
- construire les images api et webapp,
- lancer les deux conteneurs,
- exposer :
          l’API sur http://localhost:9000
          la WebApp sur http://localhost:9001

### 📦 Structure du projet
```graphql
app-hr/
├── api/           # API Spring Boot (back-end)
│   ├── Dockerfile
│   └── ...
├── webapp/        # WebApp Spring Boot (front-end)
│   ├── Dockerfile
│   └── ...
├── docker-compose.yml
└── README.md
```


### 🔧 Variables d’environnement
La WebApp a besoin de connaître l’URL de l’API pour pouvoir l’interroger. Cette URL est passée via une variable d’environnement Docker :

```yaml
environment:
  - COM_OPENCLASSROOMS_WEBAPP_APIURL=http://api:9000
```

Spring Boot la mappe automatiquement à la propriété com.openclassrooms.webapp.apiUrl.

### 📤 Pour arrêter les services
```bash
docker-compose down
```

### ✅ Vérification
Accédez à http://localhost:9001 pour utiliser l’application.
L’API est accessible en direct via http://localhost:9000/api/employees (ou autre route définie).

### 📬 Contribution
Ce projet a été réalisé dans un but d’apprentissage. Les contributions sont les bienvenues via issues ou pull requests.

### 📄 Licence
Ce projet est sous licence MIT.
----





