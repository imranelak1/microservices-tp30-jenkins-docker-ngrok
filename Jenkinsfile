pipeline {
   agent any
   tools { maven 'maven' }
   options { disableConcurrentBuilds(); timestamps(); skipDefaultCheckout(true) }
   triggers { githubPush() }
   stages {
     stage('Git Clone') { steps { git branch: 'main', url: 'https://github.com/imranelak1/microservices-tp30-jenkins-docker-ngrok.git' } }
     stage('Build and Test') { steps { script { if(isUnix()) sh 'mvn -B clean verify'; else bat 'mvn -B clean verify' } } }
     stage('Create Docker Image') { steps { script { if(isUnix()) sh 'docker build -t course7-tp30:latest .'; else bat 'docker build -t course7-tp30:latest .' } } }
     stage('Run') { steps { script { if(isUnix()) sh 'docker compose up -d --wait'; else bat 'docker compose up -d --wait' } } }
   }
   post { always { junit '**/target/surefire-reports/*.xml'; archiveArtifacts artifacts: 'target/*.jar', fingerprint: true } }
 }
