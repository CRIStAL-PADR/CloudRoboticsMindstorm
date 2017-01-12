# PFECloudRoboticsMindstorm
Master 2 Student project

Il y a deux projets, "LeJOS_PC" destiné au PC et "LeJOS_Lego" destiné aux Lego Mindstorms.

## Compilation "LeJOS_PC"

http://www.lejos.org/nxt/nxj/tutorial/Preliminaries/CompileAndRun.htm

Il existe des commandes de compilation pour "LeJOS_PC"

D'abord compiler le main :

	nxjpcc SensorTest.java
	
Ensuite le faire tourner :

	nxjpc SensorTest
	
Il est également possible de le lancer directement sur Eclipse si la machine est bien configurée.

## Compilation "LeJOS_Lego"

http://www.lejos.org/nxt/nxj/tutorial/Preliminaries/FirstProgram.htm

Il faut être branché sur le Lego Mindstorm NXT via USB pour que cela fonctionne.

Pour compiler le main et ses dépendances : 

	nxjc Main.java
	
Pour uploader le programme et le lancer directement :

	nxj -r -o Main.nxj Main
	
Si le fichier est déjà présent sur le robot, il faut aller dans l'explorateur du fichier sur la brique NXT2, choisir le fichier voulu et l'executer.

## Commandes

Le robot de base possède plusieurs commandes : 

	forward arg			// arg indique le temps qu'il avancera en millisecondes
	backward arg		// arg indique le temps qu'il reculera en millisecondes
	left arg			// arg indique l'angle de rotation vers la gauche en degré
	right arg 			// arg indique l'angle de rotation vers la gauche en degré
	stop 				// Arrête toutes les actions du robot
	
Le robot de type robogator possède les commandes précèdentes plus celles-ci :

	open arg 			// Ouvre la bouche de arg degrés
	close arg 			// Ferme la bouche de arg degrés
	ultrasound 			// Lit la valeur du capteur à ultrasons

