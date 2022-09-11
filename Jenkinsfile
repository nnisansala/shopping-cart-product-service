pipeline{
	environment{
		serviceName = 'shopping-cart-product-service'
        releaseVersion = '1.0.0'
        registryUsername = 'neranji'
        registryPassword = 'Kgnn@2281'
	}
    stages{

        stage ("git clone")
            git url:'https://github.com/nnisansala/shopping-cart-product-service.git', branch: "develop"


        stage ("compile")
            sh 'mvn compile'


        stage ("unit test")
            sh 'mvn test'

        stage ("Sonar")
            sh 'mvn sonar:sonar \
              -Dsonar.projectKey=${env.serviceName} \
              -Dsonar.host.url=http://54.226.46.30:9000 \
              -Dsonar.login=b527f125a970cb1d01adb819d1b8af596c058900'


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
