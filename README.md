Commande pour lancer tomcat: `./tomcat-startup.sh`
Commande pour arreter tomcat: `./tomcat-shutdown.sh`

Avant de deployer: `source setup-env.sh`
Commande your deployer la webapp dans tomcat: `./gradlew deploy --no-configuration-cache`
ou depuis le nix shell: `gradle deploy --no-configuration-cache`

Page accessible a [app](http://localhost:8080/app/)
