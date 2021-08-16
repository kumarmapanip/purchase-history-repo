pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                bat "mvn clean compile"
            }
        }
       
		stage('Junit5 Test') { 
            steps {

                bat "mvn test"
            }
        }
        
        stage('Build') { 
            steps {
                bat "mvn package"
            }
        }


		stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
			}
		}
		
 		stage('Maven Package'){
			steps{
				echo 'Project packaging stage'
				bat label: 'Project packaging', script: '''mvn package'''
				}
		}     
		   
        stage('Archiving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}

