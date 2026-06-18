pipeline {
    agent any

    stages {
        stage('Verify') {
            steps {
                sh 'java -version'
                sh 'git --version'
                sh 'mvn -version'
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
    }
}