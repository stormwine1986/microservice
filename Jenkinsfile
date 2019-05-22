pipeline {
    agent any 
    def maven_home = tool name: 'M3', type: 'maven';
    stages {
        stage('Build') { 
            steps {
                // 
                sh "mvn --veriosn"
                echo maven_home;
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