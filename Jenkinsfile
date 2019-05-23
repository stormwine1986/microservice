pipeline {
    agent any 
    tools {
        maven 'M3';
    }
    stages {

        stage('Build') { 
            steps {
                sh "mvn -B -DskipTests clean package";
            }
        }
        stage('Test') { 
            steps {
                sh "mvn test";
            }
        }
        stage('Deploy') { 
            steps {
                 echo "Deploy";
                 withTool{
                 	
                 }
                 script {
					docker.build("demo")
				}
            }
        }
    }
}