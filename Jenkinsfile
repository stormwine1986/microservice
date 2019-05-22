pipeline {
    agent any 
    tools {
        maven 'M3';
        tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
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
					
				}
            }
        }
    }
}