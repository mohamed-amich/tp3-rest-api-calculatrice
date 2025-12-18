# 📄 Guide de Conversion HTML vers PDF

## Méthode 1 : Impression depuis le navigateur (Recommandée)

### Étapes :
1. **Ouvrir le fichier** : Le fichier `Rapport_TP3_REST_API.html` est déjà ouvert dans votre navigateur
2. **Ouvrir le dialogue d'impression** : Appuyez sur `Ctrl + P` (Windows) ou `Cmd + P` (Mac)
3. **Configurer l'impression** :
   - **Destination** : Sélectionnez "Enregistrer au format PDF" ou "Microsoft Print to PDF"
   - **Pages** : Toutes
   - **Mise en page** : Portrait
   - **Marges** : Par défaut
   - **Options** : Cochez "Graphiques d'arrière-plan" pour conserver les couleurs
4. **Enregistrer** : Cliquez sur "Enregistrer" et choisissez le nom `Rapport_TP3_REST_API.pdf`

## Méthode 2 : Utiliser un convertisseur en ligne

### Sites recommandés :
- https://www.ilovepdf.com/html-to-pdf
- https://www.sejda.com/html-to-pdf
- https://cloudconvert.com/html-to-pdf

### Étapes :
1. Accédez à l'un des sites ci-dessus
2. Téléchargez le fichier `Rapport_TP3_REST_API.html`
3. Cliquez sur "Convertir"
4. Téléchargez le PDF généré

## Méthode 3 : Utiliser wkhtmltopdf (Ligne de commande)

### Installation :
```bash
# Windows (avec Chocolatey)
choco install wkhtmltopdf

# Linux
sudo apt-get install wkhtmltopdf

# Mac
brew install wkhtmltopdf
```

### Conversion :
```bash
wkhtmltopdf Rapport_TP3_REST_API.html Rapport_TP3_REST_API.pdf
```

## ✅ Vérification du PDF

Après la conversion, vérifiez que le PDF contient :
- ✓ Page de garde avec titre et informations
- ✓ Table des matières
- ✓ Toutes les sections (1 à 10)
- ✓ Les 5 images (architecture + 4 captures Postman)
- ✓ Les blocs de code avec coloration
- ✓ Les tableaux formatés
- ✓ Le footer avec la date

## 📍 Emplacement des fichiers

- **Rapport HTML** : `C:\Users\Mohamed Amich\Desktop\9raya\lsi 3\SOA\tp3\Rapport_TP3_REST_API.html`
- **Rapport PDF** : À enregistrer au même emplacement
- **Fichier WAR** : `C:\Users\Mohamed Amich\Desktop\9raya\lsi 3\SOA\tp3\target\calculatrice-rest.war`

## 🎯 Livrables finaux

1. ✅ **Projet Maven complet** - Prêt pour GitHub
2. ✅ **Fichier WAR** - Dans le dossier `target/`
3. ✅ **Rapport PDF** - À générer depuis le HTML
4. ✅ **README.md** - Documentation GitHub
5. ✅ **.gitignore** - Configuration Git

---

**Note** : La méthode 1 (impression depuis le navigateur) est la plus simple et préserve parfaitement la mise en forme du rapport.
