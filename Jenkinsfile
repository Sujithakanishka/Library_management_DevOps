pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build WAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t kanishkahub/library-management:v1 .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push kanishkahub/library-management:v1'
            }
        }
    }
}
