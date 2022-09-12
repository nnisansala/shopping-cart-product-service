node{
	environment{
		serviceName = 'shopping-cart-product-service'
        releaseVersion = '1.0.0'
        registryUsername = 'neranji'
        registryPassword = 'Kgnn@2281'
	}
	
	stage ("Git Clone"){
        git credentialsId: 'nnisansala-git', url:'https://github.com/nnisansala/shopping-cart-product-service.git', branch: "develop"
	}

	stage ("Compile"){
		sh 'mvn compile'
	}

	stage ("Unit Test"){
		sh 'mvn test'
	}

    stage ("Sonar"){
		sh 'mvn sonar:sonar \
		  -Dsonar.projectKey=shopping-cart-product-service \
		  -Dsonar.host.url=http://54.226.46.30:9000 \
		  -Dsonar.login=b527f125a970cb1d01adb819d1b8af596c058900'
	}

	stage ("Package") {
		sh 'mvn package'
	}


	stage ("Build Image"){
		sh 'sudo docker build -t neranji/shopping-cart-product-service:1.0.0 .'
	}


	stage ('Docker Login') {
		sh 'sudo docker login --username=neranji --password=Kgnn@2281'
	}


	stage ('Docker Push') {
		sh 'sudo docker push neranji/shopping-cart-product-service:1.0.0'
	}
	
	stage ('Deploy to EKS') {
        sh 'sudo helm upgrade --install product-service-helm product-service-helm/ --namespace=shopping-cart'

	}
}
