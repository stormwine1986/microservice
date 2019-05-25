node {
   	def mvnHome
	def dockerHome
	
	checkout scm
	
   	stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      // git 'http://gitlib/stormwine/demo.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
      dockerHome = tool 'docker'
      // git 'http://gitlib/root/ci-demo.git'
   	}
   stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
      		sh "$MVN_HOME/bin/mvn -B -DskipTests clean package"
      }
   }
   stage('Test') {
      withEnv(["MVN_HOME=$mvnHome"]) {
      		sh "$MVN_HOME/bin/mvn test"
      }
   }
   stage('Deploy') {
      withEnv(["DOKCER_HOME=$dockerHome"]) {
      		sh "$DOKCER_HOME/bin/docker build -t demo ."
      }
   }
}