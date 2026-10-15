# Déclenchement GitHub

 1. Dans Jenkins, déclarer Maven sous le nom `maven` et créer un job Pipeline depuis ce dépôt (branche `main`, chemin `Jenkinsfile`). L'agent doit disposer de Java 17 et Docker.
 2. Exposer le port local Jenkins avec `ngrok http 19930`. L'authtoken se configure localement avec `ngrok config add-authtoken ...` et ne va pas dans Git.
 3. Dans GitHub → Settings → Webhooks, ajouter `https://<domaine-ngrok>/github-webhook/`, type JSON, événement push. Définir le secret webhook dans les réglages Jenkins et GitHub.
 4. Lancer un premier build manuel, puis pousser une modification. Vérifier la livraison HTTP 200 dans GitHub et le nouveau build Jenkins causé par le push.

 L'URL gratuite peut changer après un redémarrage. Mettre alors le webhook à jour. Ne pas exposer un Jenkins sans authentification.
