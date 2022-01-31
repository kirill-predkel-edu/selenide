pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                       bat './gradlew clean build -x test'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}