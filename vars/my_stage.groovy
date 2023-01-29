def call(Closure body){
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  stage('My Stage'){
    steps{
      sh 'echo "Test 123"'
      body()
      sh 'echo "After"'
    }
  }
}
