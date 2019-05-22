pipeline {
    agent any 
    tools {
        maven 'M3'
    }
    stages {
        stage('Build') { 
            steps {
                // 
                sh "java -version"
                sh "mvn --veriosn"
            }
        }
        stage('Test') { 
            steps {
                // 
                 echo "Test";
            }
        }
        stage('Deploy') { 
            steps {
                // 
                 echo "Deploy";
            }
        }
    }
}