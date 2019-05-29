node {

   	def mvnHome
	def dockerHome
	
	checkout scm
		
	 	stage('Preparation') {
		      mvnHome = tool 'M3'
		      dockerHome = tool 'docker'
   		}
		
		 stage('Build') {
		      // 编译，单元测试，and 打包
		      withEnv(["MVN_HOME=$mvnHome"]) {
		      		try {
			      		sh "$MVN_HOME/bin/mvn -B clean package"
        			}finally{
        				junit allowEmptyResults: true, testResults: './target/surefire-reports/*.xml'      	
        				
        			}
		      }
		      // 构建Docker image,并推入仓库
		      withEnv(["DOKCER_HOME=$dockerHome"]) {
		      		sh "$DOKCER_HOME/bin/docker build -t 10.0.75.1:5000/microservice-demo ."
		      		sh "$DOKCER_HOME/bin/docker push 10.0.75.1:5000/microservice-demo"
		      }
		}
}