pipeline {
    agent any

    stages {
        stage('Restore dependencies') {
            steps {
                bat 'dotnet restore'
            }
        }
        stage('Dotnet build') {
            steps {
                bat 'dotnet build'
            }
        }
        stage('Execute tests') {
            steps {
                bat 'dotnet test --no-build --verbosity normal'
            }
        }
    }
}
