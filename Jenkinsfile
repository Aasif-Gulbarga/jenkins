pipeline {
    agent any

    tools {
        jdk 'Jdk-17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Aasif-Gulbarga/jenkins.git'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Stop Old App (if running)') {
            steps {
                sh '''
                pkill -f "java -jar" || true
                '''
            }
        }

        stage('Run Application (Deploy)') {
            steps {
                sh '''
                nohup java -jar target/*.jar > app.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo "APP RUNNING ON http://localhost:8080"
        }
    }
}