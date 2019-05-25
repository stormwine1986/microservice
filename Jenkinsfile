node {

   	def mvnHome
	def dockerHome
	
	checkout scm
	
   stage('Preparation') {
      mvnHome = tool 'M3'
      dockerHome = tool 'docker'
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
      		sh "$DOKCER_HOME/bin/docker build -t 10.0.75.1:5000/demo ."
      }
   }
}