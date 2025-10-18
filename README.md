# atelier1-jee
 # Application Web de Gestion des Commandes

## Aperçu du Projet

Cette application web a été conçue pour démontrer l'implémentation des standards Java EE en utilisant le modèle architectural MVC2. Elle offre une solution complète pour la gestion des commandes clients avec une interface moderne et des opérations CRUD sophistiquées.

## Stack Technologique

### Backend
- **Java EE** - Plateforme de développement
- **Servlets & JSP** - Couche de présentation et contrôle
- **CDI** - Gestion de l'injection de dépendances
### Frontend
- **Bootstrap 5.1.3** - Framework de design responsive

### Base de Données
- **MySQL** - Système de gestion de base de données relationnelle

### Outils
- **Maven** - Automatisation de la construction du projet
- **WildFly** - Conteneur d'application Java EE

## Architecture Logicielle

### Modèle MVC2

L'application respecte rigoureusement le patron architectural MVC2 avec une séparation claire des responsabilités :

- **Couche Modèle** : Entités métier et couche d'accès aux données (`ma.fstt.entities`, `ma.fstt.dao`)
- **Couche Vue** : Templates JSP situés dans le répertoire protégé `/WEB-INF/views/`
- **Couche Contrôleur** : Servlets gérant la logique de navigation (`ma.fstt.servlet`)

### Structure des Packages
```
ma.fstt/
├── entities/    # Objets du domaine métier
├── dao/         # Couche de persistance
├── service/     # Logique métier et interfaces
└── servlet/     # Points d'entrée de l'application
```

### Modèle de Données

Le schéma relationnel comprend 4 tables interconnectées (disponible dans `resources/database/schema.sql`) :

**Relations clés :**
- Association Client ↔ Commande (un-à-plusieurs)
- Association Commande ↔ LigneCommande (un-à-plusieurs)
- Association Produit ↔ LigneCommande (un-à-plusieurs)

## Fonctionnalités Principales

### Module Clients
- Affichage paginé de la liste des clients
- Formulaire d'enregistrement de nouveaux clients
- Édition des profils clients existants
- Suppression sécurisée avec dialogue de confirmation
- Validation multi-niveau (client-side et server-side)

### Module Produits
- Catalogue interactif des produits disponibles
- Interface CRUD complète pour la gestion du catalogue
- Contrôles de validation sur les montants et stocks

### Module Commandes
- Workflow de création de commandes intuitif
- Gestion dynamique du panier (ajout/retrait d'articles)
- Calcul en temps réel des montants totaux
- Système de statuts pour le suivi des commandes
- Consultation de l'historique par client



