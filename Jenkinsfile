pipeline {
    agent any 
    tools {
        maven 'M3'
    }
    stages {
    
    	 stage('Information') {
    	 	steps {
    	 		sh "java -version";
             	sh "mvn -veriosn";
    	 	}
    	 }

        stage('Build') { 
            steps {
                sh "mvn clean package";
                
                step([$class: 'DockerBuilderPublisher', 
                	cleanImages: false, 
                	cleanupWithJenkinsJobDelete: false, 
                	cloud: 'docker', 
                	dockerFileDirectory: './', 
                	fromRegistry: [], 
                	pushCredentialsId: '', 
                	pushOnSuccess: false, 
                	tagsString: 'demo']);
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