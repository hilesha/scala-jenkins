pipeline{
    agent{
        kubernetes {
            label 'mypod'
            containerTemplate{
                name 'maven'
                image 'maven:3.3.9-jdk-8-alpine'
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages{
        stage("Run maven"){
            steps{
                sh 'set'
                sh "echo OUTSIDE_CONTAINER_ENV_VAR = ${CONTAINER_ENV_VAR}"
                container("maven"){
                    sh 'echo MAVEN_CONTAINER_ENV_VAR = ${CONTAINER_ENV_VAR}'
                    sh 'mvn -version'
                }
            }
        }
    }
}