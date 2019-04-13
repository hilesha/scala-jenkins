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
                  image: moia/scala-sbt-kubernetes-aws-docker:8u181-2.12.8-1.2.8-1.12.5
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


