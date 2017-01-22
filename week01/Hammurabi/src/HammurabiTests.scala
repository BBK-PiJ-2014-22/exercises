

object HammurabiTests extends App {
  
  def testPlague(population : Int) = {
    println("Start Pop: "+ population 
          + " End Pop " + Hammurabi.plague(population))
  }
  
  def testStarvation(tag : String, population : Int, bushels : Int, expectedDeaths : Int) = {

    val deaths = Hammurabi.starvation(population, bushels)
    if (deaths != expectedDeaths){
      println("Test " + tag + " Failed")
      println("Pop:" + population + " Bushels: " + bushels)
      println("Expected: " + expectedDeaths + " Actual: "+ deaths)
      println()}
    else println(tag+"passed")

  }
 
  //Plague tests
  /*
  for (attempt <- 1 to 100) {
    testPlague(1000)
  }
  */
  
  testStarvation("Test 1", 100, 2000, 0)
  testStarvation("Test 2", 100, 1999, 1)
  testStarvation("Test 3", 100, 2200, 0)
  testStarvation("Test 4", 100, 0, 100)
  testStarvation("Test 5", 100, 1000, 50)
 
}