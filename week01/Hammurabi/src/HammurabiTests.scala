

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

    
  def testImmigration(tag: String, acresOwned : Int, bushelsInStorage : Int, population : Int, starved : Int, expected : Int) = {
      
      val actual = Hammurabi.immigration(acresOwned, bushelsInStorage, population, starved)
      
      if (expected == actual) println("Test " + tag + " passed")
      else {
        println("Test " + tag + " failed")
        println("Expected: " + expected + " Actual: "+actual)
      }
   }
  
  def testAssessHarvest(tag: String) = {
    val harvest = Hammurabi.assessHarvest()
    if ( harvest < 1 || harvest > 8)
      println(tag + "failed. Harvest was "+harvest)
    else println(tag + "passed")
  }
  
  def genericTest(tag: String, actual : Int, expected : Int) = {
    if (expected == actual) println("Test " + tag + " passed")
    else {
     println("Test " + tag + " failed")
     println("Expected: " + expected + " Actual: "+actual)
    }
  }
 
  //Plague tests
  /*
  for (attempt <- 1 to 100) {
    testPlague(1000)
  }
  */
  
  /*
  testStarvation("Test 1", 100, 2000, 0)
  testStarvation("Test 2", 100, 1999, 1)
  testStarvation("Test 3", 100, 2200, 0)
  testStarvation("Test 4", 100, 0, 100)
  testStarvation("Test 5", 100, 1000, 50)
 */
  
  // immigration(acresOwned : Int, bushelsInStorage : Int, population : Int, starved : Int) = {
  // (20 * number of acres + amount of grain in storage) / (100 * population) + 1
  /*
  testImmigration("Test 1", 1000, 1000, 100, 0, 3)
  testImmigration("Test 2", 2000, 1000, 100, 0, 5)
  testImmigration("Test 3", 1000, 5000, 100, 0, 3)
  testImmigration("Test 4", 1000, 10000, 100, 0, 4)
  testImmigration("Test 5", 1000, 1000, 200, 0, 2)
  testImmigration("Test 6", 1000, 1000, 300, 0, 1)
  testImmigration("Test 7", 3000, 1000, 100, 0, 7)
  testImmigration("Test 8", 1000, 1000, 100, 5, 0)
  testImmigration("Test 9", 2000, 1000, 100, 10, 0)
  testImmigration("Test 10", 1000, 5000, 100, 15, 0)
  testImmigration("Test 11", 1000, 10000, 100, 20, 0)
  testImmigration("Test 12", 1000, 1000, 200, 25, 0)
  testImmigration("Test 13", 1000, 1000, 300, 30, 0)
  testImmigration("Test 14", 3000, 1000, 100, 35, 0)

  */
  /*
  for (attempt <- 1 to 100) {
    testAssessHarvest("Test " + attempt)
  }
  */
  
  genericTest("Harvest Test 1", Hammurabi.calcHarvest(100, 1), 100)
  genericTest("Harvest Test 2", Hammurabi.calcHarvest(100, 2), 200)
  genericTest("Harvest Test 3", Hammurabi.calcHarvest(100, 3), 300)
  genericTest("Harvest Test 4", Hammurabi.calcHarvest(100, 4), 400)
  genericTest("Harvest Test 5", Hammurabi.calcHarvest(100, 5), 500)
  genericTest("Harvest Test 7", Hammurabi.calcHarvest(200, 5), 1000)
  genericTest("Harvest Test 8", Hammurabi.calcHarvest(300, 5), 1500)
  genericTest("Harvest Test 9", Hammurabi.calcHarvest(400, 5), 2000)

  
}
  
  