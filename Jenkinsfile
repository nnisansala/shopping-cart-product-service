node{
	stage ("Git Clone") {
        git url:'https://github.com/nnisansala/shopping-cart-product-service.git', branch: "develop"
	}

	stage ("Compile") {
		sh 'mvn compile'
	}

	stage ("Unit Test") {
		sh 'mvn test'
	}

    stage ("Sonar") {
		sh 'mvn sonar:sonar \
		  -Dsonar.projectKey=shopping-cart-product-service \
		  -Dsonar.host.url=http://18.212.254.64:9000 \
		  -Dsonar.login=b527f125a970cb1d01adb819d1b8af596c058900'
	}

	stage ("Package") {
		sh 'mvn package'
	}


	stage ("Build Image") {
		sh 'sudo docker build -t neranji/shopping-cart-product-service:1.0.0 .'
	}


	stage ('Docker Push') {
		withCredentials([string(credentialsId: 'neranji-docker-hub-pwd', variable: 'dockerHubpwd')]) {
			sh 'echo ${dockerHubpwd} | sudo docker login -u neranji --password-stdin'
            sh 'sudo docker push neranji/shopping-cart-product-service:1.0.0'
        }
		
	}
	
	stage ('Deploy to EKS') {
        sh 'sudo helm upgrade --install product-service-helm product-service-helm/ --namespace=shopping-cart'

	}
}
