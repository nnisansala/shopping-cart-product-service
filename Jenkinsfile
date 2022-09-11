pipeline{
	environment{
		serviceName = 'shopping-cart-product-service'
        releaseVersion = '1.0.0'
        registryUsername = 'neranji'
        registryPassword = 'Kgnn@2281'
	}
    stages{

        stage ("git clone")
            git url:'https://github.com/nnisansala/shopping-cart-product-service.git', branch: "main"


        stage ("compile")
            sh 'mvn compile'


        stage ("unit test")
            sh 'mvn test'

        stage ("Sonar")
            sh 'mvn sonar:sonar \
              -Dsonar.projectKey=${env.serviceName} \
              -Dsonar.host.url=http://34.228.199.101:9000 \
              -Dsonar.login=61d1d8b3eef6f7e20c28a30413bc470009ed3920'


        stage ("package")
            sh 'mvn package'


        stage ("build image")
            sh 'sudo docker build -t neranji/${env.serviceName}:${env.releaseVersion} .'


        stage ('docker login')
            sh 'sudo docker login --username=${env.registryUsername} --password=${env.registryPassword}'



        stage ('docker push')
            sh 'sudo docker push ${env.registryUsername}/${env.serviceName}:${env.releaseVersion}'

    }
}
