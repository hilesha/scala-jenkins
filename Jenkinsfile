pipeline{
    agent{
        kubernetes {
            label 'mypod'
            defaultContainer 'sbt'
            yaml """
            metadata:
                labels:
                    x: y
            spec:
                containers:
                - name: sbt
                  image: bigtruedata/sbt:0.13.15-2.10.6
                  command:
                  - cat
                  tty: true
                - name: aws
                  image: mesosphere/aws-cli:1.14.5
                  command:
                  - cat
                  tty: true
            """
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