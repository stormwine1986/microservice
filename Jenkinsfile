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
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Deploy') { 
            steps {
                 echo "Deploy";
                 script{
                 	sh "curl -X GET http://127.0.0.1:2375"
        			//docker.build("demo")
    			}
            }
        }
    }
}