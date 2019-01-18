# L I V R O K A Z
Projet Fil Rouge LIVROKAZ - Groupe Pierre Thomas Salva

## OBJECTIF

##### créer une app pour la gestion et la revente de livres d'occasion

    -gestion des droits
    -gestion des users et employés.
    -gestion des livres stocks,description, prix ...

#### DEFINIR VISION GLOBALE DU PROJET ET PREMIERES TACHES A REALISER

    https://trello.com/b/4yjbHXDn/projet-fil-rouge-livreocaz

#### LANGAGES DE PROGRAMMATION ET FRAMEWORKS UTILISÉS

    -java pour le backend
    -spring boot pour encapsuler le code java
    -hibernate pour la couche jpa
    -sql pour la base de données
    -angular framework javascript pour le front
    -utilisation de postman pour tester nos urls.

#### ELABORATION DU MCD

   ![MLD](/MLD_20190117.png "MLD")

## GENERATION DES CLASSES MODELES EN REVERSE ENGINEERING AVEC JBoss Tools
  
https://www.codejava.net/frameworks/hibernate/java-hibernate-reverse-engineering-tutorial-with-eclipse-and-mysql

    cet outil permet a partir des tables sql de générer les class correspondantes avec les annotations.

POUR CHAQUE ENTITE, CREATION DES METHODES DE CRUD
-------------------------------------------------

    Pour chaque class ainsi généree,on a codé les méthodes get,post,put et delete
    On retravaillera l'architecture de nos classes pour les separer en controllers et en service.
    Les controllers associent les routes aux fonctions des différents services.



AJOUT DES CLASSES LIEES A SPRING SECURITY ET JWT (Merci à Maco(u)dou !!!)
------------------------------------------------------------------------

    mise en place de la securité avec encryptage des passwords.
    mise en place de jwt avec création d'un token a durée limitée pour naviguer sur le site en tant que user loggé.
    

INSTALLATION
------------

    -cloner le projet.
    -créer un fichier application.properties src/main/resources/application.properties
    

  ```
  spring.datasource.url=jdbc:<>
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.jpa.show-sql=true
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
  spring.jpa.properties.hibernate.format_sql=true 
  ```
