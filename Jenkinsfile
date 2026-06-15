pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main-dt',
                    url: 'https://github.com/Lero19/fake-store-api-automation'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            allure includeProperties: false,
                   results: [[path: 'target/allure-results']]
        }
    }
}