pipeline {
    agent any

    environment {
        IMAGE_NAME = "jenkins"
        CONTAINER_NAME = "quirky_benz"
        DOCKER_PORT = "8081:8081"
    }

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Aasif-Gulbarga/jenkins.git'
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t jenkins ."
            }
        }

        stage('Stop Existing Container') {
            steps {
                bat '''
                docker stop quirky_benz || exit 0
                docker rm quirky_benz || exit 0
                '''
            }
        }

        stage('Run Container') {
            steps {
                bat "docker run -d --name quirky_benz -p 8080 jenkins"
            }
        }
    }

    post {
        success {
            echo 'Build & Deployment Successful!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}