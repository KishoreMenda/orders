pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = "kmenda/orders"
        DOCKER_REGISTRY = 'https://index.docker.io/v1/'
        DOCKER_USERNAME = 'kmenda' 
        DOCKER_PASSWORD = 'Burtbee@649'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/KishoreMenda/orders'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh './mvn test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Log in to Docker Hub
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                        // Push Docker image to Docker Hub
                        docker.withRegistry("${DOCKER_REGISTRY}", 'docker-hub-credentials') {
                            docker.image("${DOCKER_IMAGE_NAME}").push()
                        }
                    }
                }
            }
        }

        stage('Deploy Application') {
            steps {
                script {
                    docker.image("${DOCKER_IMAGE_NAME}").run '-d -p 8080:8080'
                }
            }
        }
    }

    post {
        success {
            echo 'Application successfully built, Docker image pushed, and container started.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
