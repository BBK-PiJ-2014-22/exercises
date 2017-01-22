

object HammurabiTests extends App {
  
  def testPlague(population : Int) = {
    println("Start Pop: "+ population 
          + " End Pop " + Hammurabi.plague(population))
  }
 
  //Plague tests
  for (attempt <- 1 to 100) {
    testPlague(1000)
  }
  
 
}