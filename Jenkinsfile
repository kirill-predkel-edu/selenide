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
                    try {
                        bat 'gradle test --tests TestListenersTest'
                    }
                    finally {
                        allure includeProperties: false, jdk: '', report: 'allure-results', results: [[path:
                                                                                                           'allure-results']]

                    }
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