def call(Map params = [:]){
  my_step = params.my_step?: default_step
  pipeline {
    agent any
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        
    }
    stages{
      stage("Stage1"){
        steps {
          my_step("Hello from shared library")
          default_step(params.PERSON)
        }
      }
    }
  }
}

def default_step(msg) {
  sh 'echo "Default"'
  sh 'echo ${msg}'
}
