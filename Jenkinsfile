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
        stage('Publish') {
            steps {
                withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
                    sh 'docker push divisionone/hello-springboot:latest'
                }
            }
        }
    }
}