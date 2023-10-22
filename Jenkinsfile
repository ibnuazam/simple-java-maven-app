node {
    docker.image('maven:3.9.0').inside('-v /root/.m2:/root/.m2') {
        stage ('Build') {
            sh 'mvn -B -DskipTests clean package'
        }
        stage ('Test') {
            try {
                sh 'mvn test'
            }
            finally {
                junit 'target/surefire-reports/*.xml'
            }
        }
        stage ('Deploy') {
            try {
                sh './jenkins/scripts/deliver.sh'
            }
            finally {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
}
