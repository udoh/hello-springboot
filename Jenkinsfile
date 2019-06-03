pipeline {
    environment {
        registry = "test-project-239803/hello-springboot"
//        registryCredential = 'gcr:test-project-239803'
    }
    agent any
    tools {
        maven 'maven'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
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
                withDockerRegistry([ credentialsId: "gcr:test-project-239803", url: "https://gcr.io" ]) {
                    sh 'docker push test-project-239803/hello-springboot:$BUILD_NUMBER'
                }
            }
        }
    }
}