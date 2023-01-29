def call(Closure body){
  echo "This is my stage in a groovy file"
  body()
  echo "After stage
}
