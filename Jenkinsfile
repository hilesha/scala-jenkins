pipeline{
    agent{
        kubernetes {
            label 'sbtpod'
            defaultContainer 'sbt'
            yaml """
            metadata:
                labels:
                    build: sbt
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
    environment{
        postgres_user= 'user'
        postgres_password= 'password'
    }
    stages{
        stage("publish jar"){
            steps{
                container("sbt"){
                    sh 'sbt package'
                    sh 'echo $postgres_user'
                    sh 'echo $postgres_password'
                }
            }
        }
        stage("check aws"){
            when{
            branch 'master'
        }
            steps{
                container("sbt"){
                    sh 'which aws'
                }
            }
        }
    }
}



