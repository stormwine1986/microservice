node {
   	
    stages {
    
    	stage('Pre') {
    		steps {
    			def mvn = tool name: 'M3', type: 'maven'
    			echo "${mvn}"
    		}
    	}

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
					docker.build("demo")
				}
            }
        }
    }
}