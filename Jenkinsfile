pipeline{
    agent{
        kubernetes {
            label 'mypod'
            containerTemplate{
                name 'sbt'
                image 'bigtruedata/sbt:0.13.15-2.10.6'
                ttyEnabled true
                command 'cat'
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
    }
}