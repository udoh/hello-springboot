pipeline {
    environment {
        registry = "divisionone/hello-springboot"
        registryCredential = 'dockerhub'
    }
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}