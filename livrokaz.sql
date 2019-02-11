-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Lun 11 Février 2019 à 12:39
-- Version du serveur :  10.1.37-MariaDB-0+deb9u1
-- Version de PHP :  7.0.33-0+deb9u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `livrokaz`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `bo_id` int(11) NOT NULL,
  `bo_author` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `bo_cover` text COLLATE utf8_roman_ci NOT NULL,
  `bo_editor` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `bo_isbn` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `bo_language` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `bo_price` float NOT NULL,
  `bo_release_date` date NOT NULL,
  `bo_stock` int(11) NOT NULL,
  `bo_synopsys` text COLLATE utf8_roman_ci NOT NULL,
  `bo_title` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `bo_topic` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `st_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `book`
--

INSERT INTO `book` (`bo_id`, `bo_author`, `bo_cover`, `bo_editor`, `bo_isbn`, `bo_language`, `bo_price`, `bo_release_date`, `bo_stock`, `bo_synopsys`, `bo_title`, `bo_topic`, `st_id`) VALUES
(1, 'Mélenchon, Jean-Luc', '', 'Seuil', '9782021317510', 'français', 2, '2016-12-01', 2996, 'Les élections de 2017 en France nous donnent le pouvoir de changer l\'histoire de notre pays. Et bla bla bla. Et bli bli bli. 6666666666666666666666666666666666666666666666666. 77777777777777777777777777777777777777.', 'L\'avenir en Commun', 'Le programme de la France Insoumise et son candida', 9),
(2, 'Gaudé, Laurent', 'https://www.actes-sud.fr/sites/default/files/couv_jpg/9782742760183.jpg', 'Actes Sud', '9782742751419', 'français', 3.5, '2004-08-01', 1996, 'En 1875, dans les monts Gargano de la région des Pouilles au sud de l\'Italie, un bandit de grand chemin Luciano Mascalzone retourne à Montepuccio après avoir purgé une peine de quinze ans de prison. Résolu, quoi qu\'il lui en coûte, à posséder Filomena Biscotti, une jeune femme dont il s\'est épris avant sa condamnation, il se présente devant la maison familiale. Une jeune femme qu\'il croit être Filomena lui ouvre la porte et s\'abandonne sans résistance. Au soir les habitants de Montepuccio, décidés à punir le criminel revenu au pays, le lapident pour ce qu\'ils pensent être un viol d\'Immacolata Biscotti, la jeune sœur, devenue vieille fille, de Filomena décédée longtemps auparavant. Luciano meurt malgré les soins de Don Giorgio, le prêtre du village.\n\nNeuf mois plus tard naît de cette union un enfant, Rocco, qui deviendra immédiatement orphelin après la mort de sa mère Immacolata. Enfant maudit par le village qui veut sa mort, Rocco est confié, par Don Giorgio qui le sauve de la vindicte, à une famille de pêcheurs de San Giocondo, le village voisin et rival. Rocco grandira chez les Scorta et deviendra à son tour un bandit écumant les Pouilles. Devenu riche, il retourne à Montepuccio pour se faire marier par Don Giorgio avec une jeune femme muette et sans nom. Ils s\'installent dans une ferme sur les hauteurs du village. Trois enfants Scorta-Mascalzone naissent de cette union : Domenico, Giuseppe, et Carmela. Bien que craint par le village dont Rocco se tient pourtant à distance, ses trois enfants sont rejetés de la communauté de Montepuccio qui voit en eux des délinquants. Seul le jeune Raffaele devient leur ami malgré les menaces et coups de ses propres parents pour le dissuader de fréquenter les Scorta-Mascalzone. À la mort de Rocco en 1928, celui-ci, selon ses dernières volontés exprimées auprès de Don Giorgio, fait don de tous ses biens à l\'Église, déshéritant ainsi ses enfants âgés de douze à dix-huit ans, à la condition expresse que tout Scorta soit désormais enterré avec fastes et honneurs par le village.\n\nPrivés de toute ressource, les trois enfants Scorta s\'embarquent pour les États-Unis avec l\'aide de Don Giorgio. L\'espoir d\'une vie nouvelle est devant eux, mais Carmela n\'est pas admise à entrer à New York en raison d\'une fièvre suspecte pour les autorités sanitaires de la ville. Plutôt que de se séparer, les trois Scorta retournent en Italie à Naples en faisant quelques petits travaux et affaires pour survivre. Un an plus tard, ils rentrent à Montepuccio, accueillis par Raffaele qui leur apprend la mort de leur mère, la Muette et son inhumation dans la fosse commune par le nouveau prêtre du village. De rage, les Scorta et Raffaele déterrent le cercueil et l\'enterrent dans une sépulture à l\'écart du cimetière. Sur la tombe de la Muette, à la demande des trois frères et sœur, Raffaele décide à son tour de prendre le nom de la famille Scorta et de devenir le frère fidèle de Carmela malgré son amour pour elle.\nUn bureau de tabac de Monte Sant\'Angelo.\n\nSuivant une idée de Carmela, les quatre Scorta s\'endettent et décident alors d\'ouvrir ensemble le premier bureau de tabac de Montepuccio au début des années 1930. Le fils cadet de Carmela, Donato, devient également un contrebandier sur initiation de son oncle Giuseppe. Le bureau de tabac fait vivre les Scorta qui petit à petit se marient et fondent de nouvelles lignées. Chacun des trois frères Scorta se diversifie dans un commerce au sein du village où ils sont enfin acceptés. Carmela se retrouve subitement veuve avec ses deux fils, Elia et Donato. Ses frères lui laissent le bénéfice du bureau de tabac, où elle va redoubler de travail pour vivre. Les années passent et ses enfants, après diverses épreuves individuelles, décident eux aussi de rester au village et de reprendre les affaires de la famille Scorta, liés qu\'ils sont à leur terre et \r\nleur sang. Seule Anna, petite fille de Carmela, sortira du village pour étudier à Bologne, dans le nord de l\'Italie. ', 'Le soleil des Scorta', 'Un truc qui se passe dans le sud de l\'Italie.', 12),
(3, 'Kranzfelder, Ivo', '', 'taschen', '978-3-8228-5011-4', 'Français', 11, '2000-01-01', 996, '1234567890abcedefghijklmonopqrstuvwxyz', 'Hopper', 'Taschen books are beautiful...', 1),
(5, 'Djian, Philippe', '', 'Gallimard', '978-2-07-012212-7', 'français', 11, '2010-11-01', 1, 'Une Fiat 500. Au volant, Marc. A côté de lui, sa plus jolie étudiante. C\'est la nuit, ils foncent chez lui finir la soirée en beauté. Au petit matin, son goût prononcé pour les jeunes élèves de son cours d\'écriture va soudain lui passer. A cause des routes de montagne ? Du néo-conservatisme ambiant ? Des crises de sa soeur ? Ou plutôt du charme des femmes mariées ? Marc ne saurait dire. Du moins, pour le moment. ', 'Incidences', 'Une Fiat 500. Au volant, Marc...', 12),
(6, 'Coe, Jonathan', 'https://images-na.ssl-images-amazon.com/images/I/51-%2BUj0IjBL._SX210_.jpg', 'Folio', '9782017317233', 'Français', 1.2, '2004-08-01', 1, 'Imaginez ! L\'Angleterre des années soixante-dix, si pittoresque, si lointaine, avec ses syndicats prospères et sa mode baba cool. Une image bon enfant que viennent lézarder de sourdes menaces : tensions sociales, montée de l\'extrême droite, et une guerre en Irlande du Nord qui ne veut pas dire son nom.', 'Bienvenue au club', 'TOPIC !!!', 12),
(7, 'Métacagoule, Jean-Luc', '', 'Seuil', '9782021317588', 'français', 3.5, '2010-12-01', 2000, 'C\'est quoi une douche sans eau ? Une duche.', 'Le passé en Commun', 'Le programme de la France Insoumise ', 9);

-- --------------------------------------------------------

--
-- Structure de la table `command_line`
--

CREATE TABLE `command_line` (
  `cl_id` int(11) NOT NULL,
  `cl_quantity` int(11) NOT NULL,
  `cl_status` bit(1) NOT NULL,
  `cl_date` datetime NOT NULL,
  `bo_id` int(11) NOT NULL,
  `cu_id` int(11) NOT NULL,
  `or_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE `customer` (
  `cu_id` int(11) NOT NULL,
  `cu_delivery_address` text COLLATE utf8_roman_ci NOT NULL,
  `cu_first_name` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `cu_invoice_address` text COLLATE utf8_roman_ci NOT NULL,
  `cu_mail` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `cu_name` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `cu_password` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `cu_phone` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `ro_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `customer`
--

INSERT INTO `customer` (`cu_id`, `cu_delivery_address`, `cu_first_name`, `cu_invoice_address`, `cu_mail`, `cu_name`, `cu_password`, `cu_phone`, `ro_id`) VALUES
(1, '{ \"no\" : \"5\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', 'Alfred', '{ \"no\" : \"5\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', 'alfreddu972@club-sandwich.co.nz', 'Musset de', 'george', '012233445566', 1),
(2, '', 'George', '{ \"no\" : \"12\", \"type_voie\" : \"rue\", \"denomination\" : \"de la Paix\", \"zip\" : \"75009\", \"town\" : \"Paris\", \"Country\" : \"France\" }', 'petitecochonnedu78@gmail.com', 'Sand', 'alfred', '0688998899', 1);

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE `employee` (
  `em_id` int(11) NOT NULL,
  `em_mail` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `em_password` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `ro_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`em_id`, `em_mail`, `em_password`, `ro_id`) VALUES
(1, 'ma@nag.er', 'manager', 2),
(2, 'ad@mi.n', 'admin', 3);

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE `orders` (
  `or_id` int(11) NOT NULL,
  `or_completed` bit(1) NOT NULL,
  `or_date` date NOT NULL,
  `or_shipping_costs` float NOT NULL,
  `or_total_cost` float NOT NULL,
  `cu_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL,
  `ro_label` varchar(50) COLLATE utf8_roman_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`ro_id`, `ro_label`) VALUES
(1, 'USER'),
(2, 'MANAGER'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Structure de la table `style`
--

CREATE TABLE `style` (
  `st_id` int(11) NOT NULL,
  `st_label_en` varchar(50) COLLATE utf8_roman_ci NOT NULL,
  `st_label_fr` varchar(50) COLLATE utf8_roman_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `style`
--

INSERT INTO `style` (`st_id`, `st_label_en`, `st_label_fr`) VALUES
(1, 'Arts', 'Arts'),
(2, 'Cartoons', 'Bande dessinée'),
(3, 'Cooking, Wines', 'Cuisine, gastronomie, vins'),
(4, 'Dictionnary, language learning methods', 'Dictionnaires, méthodes de langues'),
(5, 'Accounting, economy, law', 'Comptabilité, économie, droit'),
(6, 'Company, management, employ', 'Entreprise, gestion, emploi'),
(7, 'Esoterism', 'Esotérisme'),
(8, 'Family, hobbies', 'Famille, loisirs'),
(9, 'History, politic, news', 'Histoire, politique, actualités'),
(10, 'Computing', 'Informatique'),
(11, 'Nature, pets, gardening', 'Nature, animaux, jardinage'),
(12, 'Literature', 'Littérature'),
(13, 'Books for children', 'Livres enfants'),
(14, 'Out of school books', 'Ouvrages parascolaires'),
(15, 'Adventure and detective story', 'Romans policier et aventure'),
(16, 'Religion and spirituality', 'Religion et spiritualité'),
(17, 'Health', 'Santé, bien-être, forme'),
(18, 'Science-fiction', 'Science-fiction'),
(19, 'Human Sciences', 'Sciences humaines'),
(20, 'Sports', 'Sports'),
(21, 'University', 'Universitaire'),
(22, 'Travelling', 'Voyages');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `full_name` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `created_at`, `full_name`, `password`, `updated_at`, `username`) VALUES
(1, '2019-01-18 11:46:09', 'Josselin De France', '$2a$10$BAyVOmQFbQJ8jL3DcXpC4OnPYCtp6RtmD4doIPM8hS3naTSdac2He', NULL, 'josselin@gmail.com');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bo_id`),
  ADD KEY `FK8oyd3t8usnitp7f4qtkbpherw` (`st_id`);

--
-- Index pour la table `command_line`
--
ALTER TABLE `command_line`
  ADD PRIMARY KEY (`cl_id`),
  ADD KEY `FK4q95cl4ro5bt1fkckuvrqldb2` (`bo_id`),
  ADD KEY `FK6xevbakvx86aw8t1cnf1hp4wr` (`cu_id`),
  ADD KEY `FKmg6gbhubdhrnc1pujnyt2ighk` (`or_id`);

--
-- Index pour la table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cu_id`),
  ADD KEY `FKdbloftb45jbvxu7xp0yqo0ff5` (`ro_id`);

--
-- Index pour la table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`em_id`),
  ADD KEY `FK2t0n46pe5qyuyem57x42gyum9` (`ro_id`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`or_id`),
  ADD KEY `FKmakpb7i2dntsd2yguyqg3j3gc` (`cu_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ro_id`);

--
-- Index pour la table `style`
--
ALTER TABLE `style`
  ADD PRIMARY KEY (`st_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `bo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `command_line`
--
ALTER TABLE `command_line`
  MODIFY `cl_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `customer`
--
ALTER TABLE `customer`
  MODIFY `cu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `employee`
--
ALTER TABLE `employee`
  MODIFY `em_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
  MODIFY `or_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `ro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `style`
--
ALTER TABLE `style`
  MODIFY `st_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK8oyd3t8usnitp7f4qtkbpherw` FOREIGN KEY (`st_id`) REFERENCES `style` (`st_id`);

--
-- Contraintes pour la table `command_line`
--
ALTER TABLE `command_line`
  ADD CONSTRAINT `FK4q95cl4ro5bt1fkckuvrqldb2` FOREIGN KEY (`bo_id`) REFERENCES `book` (`bo_id`),
  ADD CONSTRAINT `FK6xevbakvx86aw8t1cnf1hp4wr` FOREIGN KEY (`cu_id`) REFERENCES `customer` (`cu_id`),
  ADD CONSTRAINT `FKmg6gbhubdhrnc1pujnyt2ighk` FOREIGN KEY (`or_id`) REFERENCES `orders` (`or_id`);

--
-- Contraintes pour la table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKdbloftb45jbvxu7xp0yqo0ff5` FOREIGN KEY (`ro_id`) REFERENCES `role` (`ro_id`);

--
-- Contraintes pour la table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FK2t0n46pe5qyuyem57x42gyum9` FOREIGN KEY (`ro_id`) REFERENCES `role` (`ro_id`);

--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKmakpb7i2dntsd2yguyqg3j3gc` FOREIGN KEY (`cu_id`) REFERENCES `customer` (`cu_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
