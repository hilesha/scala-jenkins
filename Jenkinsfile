pipeline{
    agent{
        kubernetes {
            label 'mypod'
            container {
            containerTemplate{
                name 'sbt'
                image 'bigtruedata/sbt:0.13.15-2.10.6'
                ttyEnabled true
                command 'cat'
            },
            containerTemplate{
                name 'aws'
                image 'mesosphere/aws-cli:1.14.5'
                ttyEnabled true
                command 'cat'
            },
            }
        }
    }
    stages{
        stage("Run sbt"){
            steps{
                container("sbt"){
                    sh 'sbt test'
                    sh 'sbt package'
                }
            }
        }
        stage("publish jar"){
            steps{
                container("sbt"){
                    sh 'sbt test'
                }
            }
        }
        stage("check aws"){
            steps{
                container("aws"){
                    sh 'which aws'
                }
            }
        }
    }
}