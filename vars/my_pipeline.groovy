def call(Map parameters = [:]){
  my_step = parameters.my_step?: default_step
  pipeline {
    agent any

    stages{
      stage("Stage1"){
        steps {
          my_step("Hello from shared library")
        }
      }
    }
  }
}

def default_step(msg) {
  sh 'echo ${msg}'
}
