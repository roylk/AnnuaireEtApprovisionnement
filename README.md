# AnnuaireEtApprovisionnement
[SDRS-SCMS AnnuaireEtApprovisionnement] est  application transfert de colis et annuaire d'entreprise.  l'application   aura pour but de permettre aux entreprises d'avoir une visibilité globale sur leurs  différentes filiales, sites, agences ... et permettra  en même temps de gérer l'acheminement des colis internes entre ces différents sites géolocalisés.

Note: la version 3.0.0.0 actuelle de notre application offre désormais la possibilité travers une interface graphique intuitive de:
- se connecter en entrant un login et un mot de passe correspondants aux utilisateurs créés stockés dans la table users de la base de données
Ce formulaire de connexion contrôle également ce que vous entrez et se comporte différemment selon que vous:
       - vous n'entrez rien
       - vous vous ne remplissez pas les deux champs
       - vous entrez des informations erronnées
       - vous entrez les informations correctes 
-  Créer Enregistrer à travers des formulaires graphiques incluant le contrôle des données des sites de divers types (par défaut, agence, local) dans la base de données
- Afficher les détails des sites existants et disponibles en bases de données en fonction des types (par défaut, agence, local) dans un rendu graphique sous forme de tableau en cliquant juste sur le bouton indiqué
-rafraichir la liste des sites (par défaut, agence, local) pour afficher les enregistrements les plus récents,
- Naviguer aisement entre les différentes fenêtres,
- se déconnecter 
elle propose ces fonctionnalités regroupées en deux modules(pour l'instant) à savoir:
- le module GESTION DES SITES (création, affichage fonctionnels,  mise à jour et suppression  en cours) par types 
- le module REPORTING qui est en cours d'implémentation
ces modules sont accéssibles depuis la page d'acceuil après authentification à travers:
- les boutons de raccourci mis en oeuvres à cet effet
- les menus dans une barre qui offre les mêmes fonctionnalités
elle va intégrer plus tard
- un module de gestion des utilisateurs et des habilitation
- un ou plusieurs modules de gestion d'approvisionnement entre les différents sites créés qui seront géolocalisables
les aspects "modifier Site, et Supprimer un site sont en cours de complétion
	

	************************************
*****  	     Pré-requis avant execution		*****
	************************************
afin de pouvoir installer et commencer a utiliser la version actuelle (3.0.0.0) de notre application l'utilisateur doit
- Disposer d'un environnement sur lequel est installé un JDK ou un JRE
Pour installer le JDK ou JRE dans votre environnement rendez vous ici: http://www.objis.com/formation-java/tutoriel-java-installation-jdk.html
et suivez les instructions qui conviennent à votre SE.
vous pouvez aussi suivre les instructions ci-après:

	-Rendez-vous sur la partie Java du site d’Oracle : http://www.oracle.com/technetwork/java
	-Dans la zone de droite ’software downloads’, cliquez sur le lien ’Java SE’ (pour Java Standard Edition)
	-Cliquez sur l’icône ’Java’ pour télécharger le JDK
	-Accepter la licence
	-De préférence choisir la version la plus récente (dernière sur la liste)
		-si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
		-si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
		-la version 32 bit fonctionne sur un Système Windows 32 bit ou 64 bit.
	-Cliquez sur le bouton ’Enregistrer le fichier’. Le téléchargement commence
	-Double cliquez sur le fichier téléchargé. L’assistant d’installation du JDK se lance
	-Cliquez sur le bouton ’Next’ des fenêtre qui vont s'afficher
	-Au moment d’installer un environnement d’exécution indépendant du JDK, l’assistant vous consulte. Acceptez les options par défaut et cliquez sur Next
	-Ainsi même si vous supprimez par la suite le répertoire d’installation du JDK (qui contient aussi une JRE), vous pourrez tout de même exécuter des programmes Java sur votre ordinateur
	-Vous arrivez à l’écran de fin d’installation, qui vous précise que l’installation s’est bien déroulée 
	-Cliquez sur Close: L’installation du JDK est terminée. 
-Télécharger et installer un SGBD MySQL(ou les outils qui l'intègrent)
     vous pouvez porter votre choix sur sur:
       - le package MySQl Workbench qui est téléchargeable gratuitement qui embarque un client en ligne de commande, 
         et qui peut aussi être synchronisé avec le client graphique SQLyog
       - le package WAMP qui intègre le client graphique phpMyAdmin

- disposer du driver Mysql-connector-java pour assurer la communication entre l'application et la base de donnée
(une copie accompagne le livrable de notre application)

- Savoir lancer les instructions en ligne de commande afin de pouvoir exécuter l'application
   
     

	************************************
*****  		Version du jdk utilisée	  	*****
	************************************
pour cette version de notre application nous avons utilisé la version de jdk détaillée ci-dessous
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)



	************************************
*****  	Documentation:			  	*****
	************************************

Veuillez suivre les indications suivantes pour acceder au contenu du javadoc 

1) ouvrir le dossier "livrable_module5_KOUANI" 
2) ouvrir le sous dossier "doc" qui s'y trouve
2) Double cliquez sur 'index.html'.

et vous pouvez intuitivement naviguer entre les pages

	
	************************************
***** 	Execution de l'application:    		*****
	************************************


Veuillez suivre les indications suivantes:
1) importer le fichier de sauvegarder de la base de donnée annuaireetapprovisionnement.sql dans votre SGBD MySQL(ce fichier se trouve dans le dossier
   "livrable_module5_KOUANI" 

2)naviguer jusqu'à la racine contenant le fichier AnnuaireEtApprovisionnement.jar(vous pouvez le faire graphiquement)
3)une fois que vous y êtes, lancer l'invite commande en tant que administrateur(en cliquant sur "fichier">"ouvrir l'invite de commande">"ouvrir l'invite de commande en tant qu'administrateur")
4)executer la commande java -jar AnnuaireEtApprovisionnement.jar
5)loggez vous (login: objiscam mot de passe: objis ou login: ckroyl mot de passe: royl) et cliquer sur entrer ; vous pourrez ici tester les différentes eventualités énumérer plus haut
6) laissez vous guider par les interfaces intuitives  proposées par l'application

NB: PENSEZ A PARCOURIR tous les menus et à essayer tous les boutons

