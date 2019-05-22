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
                sh "mvn -B -DskipTests clean package";
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
                 echo "Deploy";
                 script{
        			docker.build("demo")
    			}
            }
        }
    }
}