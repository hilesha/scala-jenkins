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
        stage("publish jar"){
            steps{
                container("sbt"){
                    sh 'sbt package'
                }
            }
        }
        when{
            branch 'master'
        }
        stage("check aws"){
            steps{
                container("sbt"){
                    sh 'which aws'
                }
            }
        }
    }
}



