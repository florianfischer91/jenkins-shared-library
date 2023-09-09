def call(Map params= [:]) {
    // evaluate the body block, and collect configuration into the object
    // def config = [:]
    // body.resolveStrategy = Closure.DELEGATE_FIRST
    // body.delegate = config
    // body()

    //container(name: 'test') {
        for (int i = 0; i < params.messages.size(); i++) {
            //image = config.images[i]
            //retry(3) {
            //    sh "docker pull ${env.FABRIC8_DOCKER_REGISTRY_SERVICE_HOST}:${env.FABRIC8_DOCKER_REGISTRY_SERVICE_PORT}/fabric8/${image}:${config.tag}"
            //    sh "docker tag  ${env.FABRIC8_DOCKER_REGISTRY_SERVICE_HOST}:${env.FABRIC8_DOCKER_REGISTRY_SERVICE_PORT}/fabric8/${image}:${config.tag} docker.io/fabric8/${image}:${config.tag}"
            //    sh "docker push docker.io/fabric8/${image}:${config.tag}"
            //}
            sh "echo 'Sending a message: ${params.messages[i]}'"
        }
    //}
}
