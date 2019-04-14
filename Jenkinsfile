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
        stage("run tests"){
            steps{
                container("sbt"){
                    sh 'sbt test'
                    sh 'pwd'
                    sh 'ls -ltr target/test-reports/'
                }
            }
            post{
                success{
                    junit allowEmptyResults: true, testResults: 'target/test-reports/*.xml'
                }
            }
        }
        stage("publish jar"){
            steps{
                container("sbt"){
                    sh 'sbt package'
                    sh 'echo $postgres_user'
                    sh 'echo $postgres_password'
                    sh 'echo $pwd'
                    sh 'ls -ltr target/scala-2.12/'
                }
            }
            post{
                success{
                    archiveArtifacts artifacts: 'target/scala-2.12/*.jar', allowEmptyArchive: true
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
                    input 'Approval for UAT Merge?'
                    sh 'echo Done'
                }
            }
        }
    }
}



