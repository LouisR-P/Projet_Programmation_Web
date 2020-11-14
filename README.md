# Projet_Programmation_Web
## ESIEA, 5ème année (2020-2021)

## Présentation
Projet de programmation web ayant pour finalité la réalisation d'une application web de gestion de centre équestre. Le back-end de l'application est codé avec le framework Spring (Java) et le front-end est codé avec le framework Angular (JavaScript, Typescript, Html, Css)

Cette application affiche les données à partir d'une base de données "centre_equestre" mysql en local (cf les prérequis pour procéder à son installation).

## Prérequis
### Afin de lancer l'application web, il est nécessaire de suivre ces prérequis
- Création de la base de données centre_equestre avec mysql via le MySql Command Line Client avec la commande "CREATE DATABASE centre_equestre;" (cf fichier application.properties pour les identifiants de connexion à la base).
- Ajout du rôle administrateur à l'utilisateur créé lors de l'exécution de l'application Spring via le MySql Workbench avec la commande SQL "INSERT INTO centre_equestre.user_roles(user_id, role_id) VALUES ('1', '3');".
L'utilisateur (Nom: Administrateur, mot de passe: root) hérite ainsi des droits administrateur.
