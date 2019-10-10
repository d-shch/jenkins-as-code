pipeline {
    agent any
    stages {
        stage('Example') {
            steps{
                sh 'exit 1'
            }
        }
    }
    post {
        failure {
            echo 'УПС!'
        }
    }
}