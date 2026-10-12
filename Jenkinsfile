
pipeline {
    agent any

    environment {
        DOCKER_PATH = 'C:\\Users\\sarvesh\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn -B package'
            }
        }

        stage('Docker Build') {
            steps {
                bat '"%DOCKER_PATH%" build -t java-web-lab:latest .'
            }
        }
    }

    post {
        success {
            echo 'Build and Docker image creation succeeded.'
        }
        failure {
            echo 'Pipeline failed. Check the failed stage in Console Output.'
        }
    }
}
