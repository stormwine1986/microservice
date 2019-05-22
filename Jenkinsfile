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
                 script {
					
				    def customImage = docker.build("my-image:${env.BUILD_ID}")
				
				    customImage.inside {
				        sh 'make test'
				 	}
				}
            }
        }
    }
}