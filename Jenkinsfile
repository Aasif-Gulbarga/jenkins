pipeline {
    agent {
        docker {
            image 'maven:3.9.11-eclipse-temurin-17'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            echo 'Spring Boot build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}