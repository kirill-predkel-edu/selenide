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
  }
  post('Publish Report') {
    always {
      echo 'Report is publishing..'
      script {
        allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]
      }
    }
  }
}