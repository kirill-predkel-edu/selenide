pipeline {
    agent any

    stages {
        stage('Build') {
            echo 'Building..'
            steps {
                script {
                       bat './gradlew clean build -x test'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                script {
                    bat 'gradle test --tests TestListenersTest'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}