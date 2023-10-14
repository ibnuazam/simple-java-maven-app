node {
    stage('Build') {
        try {
            docker.image('maven:3.9.0').inside('-v /root/.m2:/root/.m2') {
                sh 'mvn -B -DskipTests clean package'
            }
        } finally {
            junit 'target/surefire-reports/*.xml'
        }
    }
    stage('Test') {
        try {
            docker.image('maven:3.9.0').inside {
                sh 'mvn test'
            }
        } finally {
            junit 'target/surefire-reports/*.xml'
        }
    }
    stage('Deliver') {
        try {
            sh './jenkins/scripts/deliver.sh'
        } finally {
            junit 'target/surefire-reports/*.xml'
        }
    }
}