# 🧮 API REST Calculatrice - TP3 SOA

## 📋 Description

Service REST développé en Java avec JAX-RS (Jakarta RESTful Web Services) et Jersey, permettant d'effectuer des opérations arithmétiques de base (addition, soustraction, multiplication, division).

## 🎯 Objectifs du TP

- ✅ Comprendre la conception d'une API REST
- ✅ Créer un service REST en Java avec JAX-RS
- ✅ Utiliser Jersey comme implémentation JAX-RS
- ✅ Structurer un projet Maven (packaging .war)
- ✅ Déployer le projet dans Tomcat
- ✅ Manipuler les annotations REST (@Path, @GET, @QueryParam, @Produces, etc.)
- ✅ Tester les endpoints avec Postman

## 🛠️ Technologies Utilisées

- **Langage**: Java 11
- **Build Tool**: Apache Maven 3.x
- **Framework REST**: JAX-RS (Jakarta RESTful Web Services) 3.1.0
- **Implémentation JAX-RS**: Jersey 3.1.3
- **Serveur d'Application**: Apache Tomcat 10.x
- **Format de données**: JSON (avec Jackson)
- **Outil de test**: Postman

## 📁 Structure du Projet

```
tp3/
├── src/
│   ├── main/
│   │   ├── java/com/example/rest/
│   │   │   ├── Calculatrice.java        # Logique métier
│   │   │   ├── Operation.java           # Enumération des opérations
│   │   │   ├── CalculRest.java          # Ressource REST
│   │   │   └── RestApplication.java     # Configuration JAX-RS
│   │   ├── resources/
│   │   └── webapp/WEB-INF/
│   │       └── web.xml                  # Configuration servlet
│   └── test/
├── target/
│   └── calculatrice-rest.war            # Fichier déployable
├── pom.xml                              # Configuration Maven
└── README.md
```

## 🚀 Installation et Déploiement

### Prérequis

- Java JDK 11 ou supérieur
- Apache Maven 3.6+
- Apache Tomcat 10.x
- Postman (pour les tests)

### Compilation

```bash
mvn clean package
```

Le fichier WAR sera généré dans `target/calculatrice-rest.war`

### Déploiement sur Tomcat

**Méthode 1 : Déploiement manuel**
1. Copier `calculatrice-rest.war` dans le dossier `webapps/` de Tomcat
2. Démarrer Tomcat : `bin/startup.bat` (Windows) ou `bin/startup.sh` (Linux)
3. L'application sera accessible à : `http://localhost:8080/calculatrice-rest/`

**Méthode 2 : Via le Manager de Tomcat**
1. Accéder à `http://localhost:8080/manager/html`
2. Utiliser la section "WAR file to deploy"
3. Sélectionner le fichier WAR et cliquer sur "Deploy"

## 📡 Endpoints API

### URL de base
```
http://localhost:8080/calculatrice-rest/api/calculatrice
```

### Opérations disponibles

#### 1. Addition
```
GET /api/calculatrice/addition?a={valeur1}&b={valeur2}
```

**Exemple:**
```
GET http://localhost:8080/calculatrice-rest/api/calculatrice/addition?a=10&b=20
```

**Réponse:**
```json
{
    "operation": "ADDITION",
    "operandeA": 10.0,
    "operandeB": 20.0,
    "resultat": 30.0,
    "message": "Succès",
    "succes": true
}
```

#### 2. Soustraction
```
GET /api/calculatrice/soustraction?a={valeur1}&b={valeur2}
```

**Exemple:**
```
GET http://localhost:8080/calculatrice-rest/api/calculatrice/soustraction?a=10&b=5
```

**Réponse:**
```json
{
    "operation": "SOUSTRACTION",
    "operandeA": 10.0,
    "operandeB": 5.0,
    "resultat": 5.0,
    "message": "Succès",
    "succes": true
}
```

#### 3. Multiplication
```
GET /api/calculatrice/multiplication?a={valeur1}&b={valeur2}
```

**Exemple:**
```
GET http://localhost:8080/calculatrice-rest/api/calculatrice/multiplication?a=5&b=5
```

**Réponse:**
```json
{
    "operation": "MULTIPLICATION",
    "operandeA": 5.0,
    "operandeB": 5.0,
    "resultat": 25.0,
    "message": "Succès",
    "succes": true
}
```

#### 4. Division
```
GET /api/calculatrice/division?a={valeur1}&b={valeur2}
```

**Exemple:**
```
GET http://localhost:8080/calculatrice-rest/api/calculatrice/division?a=10&b=2
```

**Réponse:**
```json
{
    "operation": "DIVISION",
    "operandeA": 10.0,
    "operandeB": 2.0,
    "resultat": 5.0,
    "message": "Succès",
    "succes": true
}
```

### Gestion des erreurs

**Division par zéro:**
```
GET /api/calculatrice/division?a=10&b=0
```

**Réponse (Status 400):**
```json
{
    "operation": "DIVISION",
    "operandeA": 10.0,
    "operandeB": 0.0,
    "resultat": 0.0,
    "message": "Division par zéro impossible",
    "succes": false
}
```

## 🧪 Tests avec Postman

1. Ouvrir Postman
2. Créer une nouvelle requête GET
3. Entrer l'URL de l'endpoint souhaité
4. Ajouter les paramètres `a` et `b` dans la section "Params"
5. Cliquer sur "Send"
6. Vérifier la réponse JSON

## 🏗️ Architecture

```
Client (Postman/Browser)
        ↓
   HTTP Request
        ↓
  Apache Tomcat
        ↓
Jersey (JAX-RS)
        ↓
  CalculRest (Resource)
        ↓
  Calculatrice (Business Logic)
        ↓
   JSON Response
```

## 📦 Dépendances Maven

```xml
<dependencies>
    <!-- JAX-RS API -->
    <dependency>
        <groupId>jakarta.ws.rs</groupId>
        <artifactId>jakarta.ws.rs-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    
    <!-- Jersey Server -->
    <dependency>
        <groupId>org.glassfish.jersey.core</groupId>
        <artifactId>jersey-server</artifactId>
        <version>3.1.3</version>
    </dependency>
    
    <!-- Jersey Container Servlet -->
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-servlet</artifactId>
        <version>3.1.3</version>
    </dependency>
    
    <!-- Jersey HK2 (Dependency Injection) -->
    <dependency>
        <groupId>org.glassfish.jersey.inject</groupId>
        <artifactId>jersey-hk2</artifactId>
        <version>3.1.3</version>
    </dependency>
    
    <!-- Jersey JSON Jackson -->
    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-jackson</artifactId>
        <version>3.1.3</version>
    </dependency>
</dependencies>
```

## 📝 Livrables

- ✅ Projet Maven complet (GitHub)
- ✅ Fichier WAR (`target/calculatrice-rest.war`)
- ✅ Rapport PDF avec captures Postman
- ✅ Documentation de l'API

## 🎓 Auteur

**Module**: SOA (Service Oriented Architecture)  
**Niveau**: LSI 3  
**Date**: Décembre 2025

## 📄 Licence

Ce projet est réalisé dans un cadre pédagogique.

## 🔗 Ressources

- [Documentation JAX-RS](https://jakarta.ee/specifications/restful-ws/)
- [Jersey Documentation](https://eclipse-ee4j.github.io/jersey/)
- [Apache Tomcat](https://tomcat.apache.org/)
- [Maven](https://maven.apache.org/)
