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
        
        stage('Build Code') {
            steps {
                script {
                    sh './mvnw clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh './mvnw test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
                sh "docker push ${DOCKER_IMAGE_NAME}"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                kubectl apply -f k8s/orders-deployment.yaml
                kubectl apply -f k8s/orders-service.yaml
                '''
            }
        }
    }

    post {
        success {
            echo 'Application successfully built, Docker image pushed, and deployed to Kubernetes!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
