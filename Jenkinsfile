pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
<<<<<<< HEAD
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify -Dheadless=false -Dremote=true -DseleniumGridURL=http://172.18.0.4:4444/wd/hub -Dbrowser=chrome'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
=======
                sh 'mvn -B -DskipTests clean package' 
>>>>>>> 8f0dfd94048e2ca702f6da6faadf2b8ccbacd895
            }
        }
		stage('Test') { 
            steps {
                sh 'mvn clean verify -Dheadless=false -Dremote=true -DseleniumGridURL=http://172.19.0.4:4444/wd/hub -Dbrowser=firefox' 
            }
        }
    }
}