# L I V R O K A Z
Projet Fil Rouge LIVROKAZ - Groupe Pierre Thomas Salva

## OBJECTIF

##### créer une app pour la gestion et la revente de livres d'occasion

* gestion des droits
* gestion des users et employés.
* gestion des livres stocks,description, prix ...

#### DEFINIR VISION GLOBALE DU PROJET ET PREMIERES TACHES A REALISER

https://trello.com/b/4yjbHXDn/projet-fil-rouge-livreocaz

#### LANGAGES DE PROGRAMMATION ET FRAMEWORKS UTILISÉS

* java pour le backend
* spring boot pour encapsuler le code java
* hibernate pour la couche jpa
* sql pour la base de données
* angular framework javascript pour le front
* utilisation de postman pour tester nos urls.

#### ELABORATION DU MCD

   ![MLD](/MLD_20190117.png "MLD")

#### GENERATION DES CLASSES MODELES EN REVERSE ENGINEERING AVEC JBoss Tools
  
https://www.codejava.net/frameworks/hibernate/java-hibernate-reverse-engineering-tutorial-with-eclipse-and-mysql

    cet outil permet a partir des tables sql de générer les class correspondantes avec les annotations.

CREATION DES METHODES DE CRUD
-------------------------------------------------

    Pour chaque class ainsi générée,on a codé les méthodes get,post,put et delete
    On retravaillera l'architecture de nos classes pour les separer en controllers et en service.
    Les controllers associent les routes aux fonctions des différents services.



AJOUT DES CLASSES LIEES A SPRING SECURITY ET JWT (Merci à Maco(u)dou !!!)
------------------------------------------------------------------------

* mise en place de la securité avec encryptage des passwords.
* mise en place de jwt avec création d'un token a durée limitée pour naviguer sur le site en tant que user loggé.
    

INSTALLATION
------------

* cloner le projet.
* créer un fichier application.properties src/main/resources/application.properties
    

  ```java
  spring.datasource.url=jdbc:<your own localhost>
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.jpa.show-sql=true
  spring.jpa.hibernate.ddl-auto=create
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
  spring.jpa.properties.hibernate.format_sql=true 
  ```
* créer un fichier SecurityConstants /security/SecurityConstants.java
    
 ```java
 package co.simplon.livrokaz.security;

public class SecurityConstants {
	public static final String SIGN_UP_URLS = "/user/**";
    public static final String SECRET_KEY = "inserersapropreclef";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long TOKEN_EXPIRATION_TIME = 30000000;
}
```

* remplir la base de données pour effectuer des tests
  Créer une table `livrokaz(1)` et lancer le script livrokaz.sql qui se trouve à la racine du projet
  
## SESSION 5 - OBJECTIF : CREATION D'UN FRONTEND ANGULAR RELIE AU BACK

#### DEMARRAGE DU PROJET ANGULAR
https://angular.io/guide/quickstart
On installe l'environnement de développement : Node.js, NPM et Angular CLI.
On génère un nouveau projet Angular dans un répertoire dédié avec la commande ng new livrokaz

#### STRUCTURE DU CODE
On structure le projet en créant 3 répertoires : MODEL, VIEW ET SERVICE

###### MODEL
Dans MODEL, on crée nos classes objets équivalentes aux entités du back Java, en gardant la même syntaxe des noms de variables (et sans les getters et setters, sinon c'est un bordel sans nom...)

###### VIEW
Dans VIEW, la commande ng g c <nom de component>, nous permet de générer les components qui constituent les vues de notre application : header, footer, barre de recherche, vue d'une liste de livres, vue des détails d'un livre, etc. ...

###### SERVICE
Dans SERVICE on place les classes et méthodes qui permettront de relier le front-end au back-end via des requêtes http.

###### ROUTING
On attribue à chaque component une route, définie dans le fichier app-routing.module.ts. Lors de la navigation sur le site, le chemin indiqué dans la barre d'adresses permet donc d'afficher un ou plusieurs components au choix. Ex: à l'adresse http://localhost:4200/book-list on aura l'affichage de la liste de tous les livres présents en base de données. Un clic "éditer le livre n°5" "re-route" l'application vers http://localhost:4200/book-detail/5 : le component dédié à l'affichage des détails d'un livre remplace alors la vue précédente sans qu'il ait été nécessaire de faire appel au back-end.


#### STRUCTURE DE L'APPLICATION

L'application permet pour l'instant d'accéder à la base de données pour afficher une liste de livres, accéder aux détails d'un livre et éventuellement les modifier. On peut également ajouter ou supprimer un livre de la base de données.
Une barre de recherche permet de filtrer les livres par titre, auteur ou éditeur.




REPARTITION DU TRAVAIL EFFECTUE
-------------------------------

