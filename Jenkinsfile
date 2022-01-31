pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    try {
                       bat './gradlew clean build -x test'
                    }
                    finally {
                        echo 'Building'
                    }

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