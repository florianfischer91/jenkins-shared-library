def call(Map pparams = [:]){
  my_step = pparams.my_step?: default_step
  pipeline {
    agent any
    //pparams.custom_params()
    /*parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        
    }*/
    stages{
      stage("Stage1"){
        steps {
          sh 'docker version'
          sh "docker $(echo ${my_step("Hello from shared library")})"
          //default_step(params.PERSON)
          default_step("Default Value")
        }
      }
    }
  }
}

def default_step(msg) {
  sh 'echo "Default"'
  sh "echo '${msg}'"
}
