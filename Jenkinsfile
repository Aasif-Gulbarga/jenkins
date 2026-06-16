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
        git 'Default'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Aasif-Gulbarga/jenkins.git'
            }
        }

        stage('Build with Maven (Docker)') {
                    steps {
                        bat '''
                        docker run --rm ^
                        -v %cd%:/app ^
                        -v m2:/root/.m2 ^
                        -w /app ^
                        maven:3.9.6-eclipse-temurin-17 ^
                        mvn clean package -DskipTests
                        '''
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