pipeline {
    environment {
        registry = "divisionone/hello-springboot"
        registryCredential = 'dockerhub'
    }
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        tage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage ('Build war') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        stage('Build docker image') {
            steps{
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Push docker image') {
            steps {
                withDockerRegistry([ credentialsId: "dockerhub", url: "" ]) {
                    sh 'docker push divisionone/hello-springboot:latest'
                }
            }
        }
    }
}