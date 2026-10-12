
pipeline {
    agent any

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
                bat 'docker build -t java-web-lab:latest .'
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
