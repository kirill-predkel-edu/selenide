pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                script {
                       bat 'gradle clean build -x test'
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

        stage('Reporting') {
            steps {
                echo 'Report....'
                allure includeProperties: false, jdk: '', report: 'build/allure-results', results: [[path: 'build/allure-results']]
            }
        }
    }
}