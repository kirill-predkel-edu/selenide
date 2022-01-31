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
                        bat 'gradle test --tests TestListenersTest.Library'
                }
            }
        }
    }
  post('Publish Report') {
    always {
      script {
        allure([
            includeProperties: false,
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: '**/allure_results']]
        ])
      }
    }
  }
}