pipeline{
    agent{
        kubernetes {
            label 'mypod'
            yamlFile 'examples/KubernetesPod.yml'
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