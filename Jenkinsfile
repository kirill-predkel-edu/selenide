pipeline {
    agent any

stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                script {
                    try {
                        bat 'gradle test --tests TestListenersTest.Library'
                    }
                    finally {
                        allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
                    }
                }
            }
        }
    }

}