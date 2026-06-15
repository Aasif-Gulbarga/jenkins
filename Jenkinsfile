pipeline {
    agent any

        stages {
            stage('Clone') {
                steps {
                    git branch: 'main',
                        url: 'https://github.com/Aasif-Gulbarga/jenkins.git'
                }
            }
        }
    }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t jenkins-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop jenkins-app || true
                    docker rm jenkins-app || true
                    docker run -d -p 8081:8081 --name jenkins-app jenkins-app
                '''
            }
        }
    }
}