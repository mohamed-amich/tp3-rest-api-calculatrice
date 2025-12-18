# 🚀 Guide de Publication sur GitHub

## ✅ Étapes Déjà Complétées

- [x] Dépôt Git local initialisé
- [x] Tous les fichiers ajoutés (11 fichiers)
- [x] Premier commit créé
- [x] Branche renommée en `main`

## 📋 Étapes Restantes

### 1. Créer le Dépôt sur GitHub

**Vous devez maintenant :**

1. **Se connecter à GitHub** dans le navigateur ouvert
   - URL: https://github.com/login

2. **Créer un nouveau dépôt**
   - Après connexion, aller sur : https://github.com/new
   - Ou cliquer sur le bouton "+" en haut à droite → "New repository"

3. **Remplir le formulaire :**
   ```
   Repository name: tp3-rest-api-calculatrice
   Description: Service REST Calculatrice avec JAX-RS et Jersey - TP3 SOA
   Visibilité: Public (ou Private selon votre choix)
   
   ⚠️ IMPORTANT: Ne cochez PAS les options suivantes:
   ❌ Add a README file
   ❌ Add .gitignore
   ❌ Choose a license
   
   (Nous avons déjà ces fichiers localement)
   ```

4. **Cliquer sur "Create repository"**

### 2. Copier l'URL du Dépôt

Après la création, GitHub vous montrera une page avec plusieurs commandes.

**Copiez l'URL HTTPS qui ressemble à :**
```
https://github.com/VOTRE_USERNAME/tp3-rest-api-calculatrice.git
```

### 3. Commandes à Exécuter

Une fois que vous avez l'URL, revenez ici et exécutez ces commandes :

```bash
# Ajouter le dépôt distant (remplacez <URL> par votre URL GitHub)
git remote add origin <URL>

# Vérifier que le remote est bien ajouté
git remote -v

# Pousser le code vers GitHub
git push -u origin main
```

## 📝 Exemple Complet

Si votre username GitHub est `mohamedamich`, voici les commandes exactes :

```bash
git remote add origin https://github.com/mohamedamich/tp3-rest-api-calculatrice.git
git push -u origin main
```

## 🔐 Authentification

Si GitHub demande une authentification :

### Option 1 : Personal Access Token (Recommandé)
1. Aller sur : https://github.com/settings/tokens
2. Cliquer "Generate new token" → "Generate new token (classic)"
3. Donner un nom : "TP3 Upload"
4. Cocher : `repo` (Full control of private repositories)
5. Cliquer "Generate token"
6. **COPIER LE TOKEN** (vous ne le verrez qu'une fois!)
7. Utiliser ce token comme mot de passe lors du push

### Option 2 : GitHub CLI
```bash
# Installer GitHub CLI si pas déjà fait
winget install GitHub.cli

# Se connecter
gh auth login

# Pousser le code
git push -u origin main
```

## ✅ Vérification

Après le push, vérifiez sur GitHub que :
- ✓ Les 11 fichiers sont présents
- ✓ Le README.md s'affiche correctement
- ✓ Le code source est visible dans `src/`
- ✓ Le rapport HTML est présent

## 🎯 Résultat Attendu

Votre dépôt GitHub contiendra :

```
tp3-rest-api-calculatrice/
├── .gitignore
├── GUIDE_CONVERSION_PDF.md
├── README.md
├── RESUME_PROJET.md
├── Rapport_TP3_REST_API.html
├── pom.xml
└── src/
    └── main/
        ├── java/com/example/rest/
        │   ├── CalculRest.java
        │   ├── Calculatrice.java
        │   ├── Operation.java
        │   └── RestApplication.java
        └── webapp/WEB-INF/
            └── web.xml
```

## 🔗 Partage du Projet

Une fois publié, vous pourrez partager le lien :
```
https://github.com/VOTRE_USERNAME/tp3-rest-api-calculatrice
```

## 📌 Commandes Git Utiles

```bash
# Voir le statut
git status

# Voir l'historique
git log --oneline

# Voir les remotes configurés
git remote -v

# Ajouter des modifications futures
git add .
git commit -m "Description des modifications"
git push
```

## ⚠️ Problèmes Courants

### Erreur : "remote origin already exists"
```bash
git remote remove origin
git remote add origin <URL>
```

### Erreur : "failed to push some refs"
```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

### Erreur d'authentification
- Utilisez un Personal Access Token au lieu du mot de passe
- Ou utilisez GitHub CLI : `gh auth login`

---

**Une fois ces étapes terminées, revenez me dire et je vérifierai que tout est bien en ligne!** 🚀
