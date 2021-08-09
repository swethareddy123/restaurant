pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn -B clean verify'
            }
        }
    }
}