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
  spring.jpa.hibernate.ddl-auto=update
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
  
```sql
INSERT INTO `style` (`st_id`, `st_label_fr`, `st_label_en`) VALUES
(1, 'Arts', 'Arts'),
(2, 'Bande dessinée', 'Cartoons'),
(3, 'Cuisine, gastronomie, vins', 'Cooking, Wines'),
(4, 'Dictionnaires, méthodes de langues', 'Dictionnary, language learning methods'),
(5, 'Comptabilité, économie, droit', 'Accounting, economy, law'),
(6, 'Entreprise, gestion, emploi', 'Company, management, employ'),
(7, 'Esotérisme', 'Esoterism'),
(8, 'Famille, loisirs', 'Family, hobbies'),
(9, 'Histoire, politique, actualités', 'History, politic, news'),
(10, 'Informatique', 'Computing'),
(11, 'Nature, animaux, jardinage', 'Nature, pets, gardening'),
(12, 'Littérature', 'Literature'),
(13, 'Livres enfants', 'Books for children'),
(14, 'Ouvrages parascolaires', 'Out of school books'),
(15, 'Romans policier et aventure', 'Adventure and detective story'),
(16, 'Religion et spiritualité', 'Religion and spirituality'),
(17, 'Santé, bien-être, forme', 'Health'),
(18, 'Science-fiction', 'Science-fiction'),
(19, 'Sciences humaines', 'Human Sciences'),
(20, 'Sports', 'Sports'),
(21, 'Universitaire', 'University'),
(22, 'Voyages', 'Travelling');



INSERT INTO `book` (`bo_id`, `bo_title`, `bo_author`, `bo_editor`, `bo_isbn`, `bo_cover`, `bo_topic`, `bo_synopsys`, `bo_release_date`, `bo_price`, `bo_stock`, `bo_language`, `st_id`) VALUES
(1, 'L\'avenir en Commun', 'Mélenchon, Jean-Luc', 'Seuil', '9782021317510', '', 'Le programme de la France Insoumise et son candida', 'Les élections de 2017 en France nous donnent le pouvoir de changer l\'histoire de notre pays. Et bla bla bla. Et bli bli bli. 6666666666666666666666666666666666666666666666666. 77777777777777777777777777777777777777.', '2016-12-01', '0.425', 2000, 'français', 9),
(2, 'Le soleil des Scorta', 'Gaudé, Laurent', 'Actes Sud', '9782742751419', 'https://www.actes-sud.fr/sites/default/files/couv_jpg/9782742760183.jpg', 'Un truc qui se passe dans le sud de l\'Italie.', 'En 1875, dans les monts Gargano de la région des Pouilles au sud de l\'Italie, un bandit de grand chemin Luciano Mascalzone retourne à Montepuccio après avoir purgé une peine de quinze ans de prison. Résolu, quoi qu\'il lui en coûte, à posséder Filomena Biscotti, une jeune femme dont il s\'est épris avant sa condamnation, il se présente devant la maison familiale. Une jeune femme qu\'il croit être Filomena lui ouvre la porte et s\'abandonne sans résistance. Au soir les habitants de Montepuccio, décidés à punir le criminel revenu au pays, le lapident pour ce qu\'ils pensent être un viol d\'Immacolata Biscotti, la jeune sœur, devenue vieille fille, de Filomena décédée longtemps auparavant. Luciano meurt malgré les soins de Don Giorgio, le prêtre du village.\n\nNeuf mois plus tard naît de cette union un enfant, Rocco, qui deviendra immédiatement orphelin après la mort de sa mère Immacolata. Enfant maudit par le village qui veut sa mort, Rocco est confié, par Don Giorgio qui le sauve de la vindicte, à une famille de pêcheurs de San Giocondo, le village voisin et rival. Rocco grandira chez les Scorta et deviendra à son tour un bandit écumant les Pouilles. Devenu riche, il retourne à Montepuccio pour se faire marier par Don Giorgio avec une jeune femme muette et sans nom. Ils s\'installent dans une ferme sur les hauteurs du village. Trois enfants Scorta-Mascalzone naissent de cette union : Domenico, Giuseppe, et Carmela. Bien que craint par le village dont Rocco se tient pourtant à distance, ses trois enfants sont rejetés de la communauté de Montepuccio qui voit en eux des délinquants. Seul le jeune Raffaele devient leur ami malgré les menaces et coups de ses propres parents pour le dissuader de fréquenter les Scorta-Mascalzone. À la mort de Rocco en 1928, celui-ci, selon ses dernières volontés exprimées auprès de Don Giorgio, fait don de tous ses biens à l\'Église, déshéritant ainsi ses enfants âgés de douze à dix-huit ans, à la condition expresse que tout Scorta soit désormais enterré avec fastes et honneurs par le village.\n\nPrivés de toute ressource, les trois enfants Scorta s\'embarquent pour les États-Unis avec l\'aide de Don Giorgio. L\'espoir d\'une vie nouvelle est devant eux, mais Carmela n\'est pas admise à entrer à New York en raison d\'une fièvre suspecte pour les autorités sanitaires de la ville. Plutôt que de se séparer, les trois Scorta retournent en Italie à Naples en faisant quelques petits travaux et affaires pour survivre. Un an plus tard, ils rentrent à Montepuccio, accueillis par Raffaele qui leur apprend la mort de leur mère, la Muette et son inhumation dans la fosse commune par le nouveau prêtre du village. De rage, les Scorta et Raffaele déterrent le cercueil et l\'enterrent dans une sépulture à l\'écart du cimetière. Sur la tombe de la Muette, à la demande des trois frères et sœur, Raffaele décide à son tour de prendre le nom de la famille Scorta et de devenir le frère fidèle de Carmela malgré son amour pour elle.\nUn bureau de tabac de Monte Sant\'Angelo.\n\nSuivant une idée de Carmela, les quatre Scorta s\'endettent et décident alors d\'ouvrir ensemble le premier bureau de tabac de Montepuccio au début des années 1930. Le fils cadet de Carmela, Donato, devient également un contrebandier sur initiation de son oncle Giuseppe. Le bureau de tabac fait vivre les Scorta qui petit à petit se marient et fondent de nouvelles lignées. Chacun des trois frères Scorta se diversifie dans un commerce au sein du village où ils sont enfin acceptés. Carmela se retrouve subitement veuve avec ses deux fils, Elia et Donato. Ses frères lui laissent le bénéfice du bureau de tabac, où elle va redoubler de travail pour vivre. Les années passent et ses enfants, après diverses épreuves individuelles, décident eux aussi de rester au village et de reprendre les affaires de la famille Scorta, liés qu\'ils sont à leur terre et leur sang. Seule Anna, petite fille de Carmela, sortira du village pour étudier à Bologne, dans le nord de l\'Italie. ', '2004-08-01', '3.330', 7, 'français', 12),
(3, 'Hopper', 'Kranzfelder, Ivo', 'taschen', '978-3-8228-5011-4', '', 'Taschen books are beautiful...', '1234567890abcedefghijklmonopqrstuvwxyz', '2000-01-01', '456.000', 0, 'Français', 1),
(5, 'Incidences', 'Djian, Philippe', 'Gallimard', '978-2-07-012212-7', '', 'Une Fiat 500. Au volant, Marc...', 'Une Fiat 500. Au volant, Marc. A côté de lui, sa plus jolie étudiante. C\'est la nuit, ils foncent chez lui finir la soirée en beauté. Au petit matin, son goût prononcé pour les jeunes élèves de son cours d\'écriture va soudain lui passer. A cause des routes de montagne ? Du néo-conservatisme ambiant ? Des crises de sa soeur ? Ou plutôt du charme des femmes mariées ? Marc ne saurait dire. Du moins, pour le moment. ', '2010-11-01', '11.000', 1, 'français', 12),
(6, 'Bienvenue au club', 'Coe, Jonathan', 'Folio', '9782017317233', 'https://images-na.ssl-images-amazon.com/images/I/51-%2BUj0IjBL._SX210_.jpg', 'TOPIC !!!', 'Imaginez ! L\'Angleterre des années soixante-dix, si pittoresque, si lointaine, avec ses syndicats prospères et sa mode baba cool. Une image bon enfant que viennent lézarder de sourdes menaces : tensions sociales, montée de l\'extrême droite, et une guerre en Irlande du Nord qui ne veut pas dire son nom.', '2004-08-01', '1.200', 1, 'Français', 12),
(7, 'Le passé en Commun', 'Métacagoule, Jean-Luc', 'Seuil', '9782021317588', '', 'Le programme de la France Insoumise ', 'C\'est quoi une douche sans eau ? Une duche.', '2010-12-01', '3.500', 2000, 'français', 9);



INSERT INTO `role` (`ro_id`, `ro_label`) VALUES
(1, 'USER'),
(2, 'MANAGER'),
(3, 'ADMIN');

INSERT INTO `customer` (`cu_id`, `cu_name`, `cu_first_name`, `cu_invoice_address`, `cu_delivery_address`, `cu_phone`, `cu_mail`, `cu_password`, `ro_id`) VALUES
(1, 'Musset de', 'Alfred', '{ \"no\" : \"5\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', '{ \"no\" : \"5\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', '012233445566', 'alfreddu972@club-sandwich.co.nz', 'george', 1),
(2, 'Sand', 'George', '{ \"no\" : \"12\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', '', '0688998899', 'petitecochonnedu78@gmail.com', 'alfred', 1);





INSERT INTO `employee` (`em_id`, `em_mail`, `em_password`, `ro_id`) VALUES
(1, 'ma@nag.er', 'manager', 2),
(2, 'ad@mi.n', 'admin', 3);
```

