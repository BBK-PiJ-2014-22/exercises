import scala.util.Random
import scala.math


object Hammurabi extends App {
 
  def printIntroductoryMessage()  = {
    println("""Congratulations, you are the newest ruler of ancient Samaria, elected
  for a ten year term of office. Your duties are to dispense food, direct
  farming, and buy and sell land as needed to support your people. Watch
  out for rat infestations and the plague! Grain is the general currency,
  measured in bushels. The following will help you in your decisions:
  * Each person needs at least 20 bushels of grain per year to survive.
  * Each person can farm at most 10 acres of land.
  * It takes 2 bushels of grain to farm an acre of land.
  * The market price for land fluctuates yearly.
  Rule wisely and you will be showered with appreciation at the end of
  your term. Rule poorly and you will be kicked out of office!""")
  }
  
  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
    case _ : Throwable =>
      println("That's not an integer. Please enter an integer.")
      readInt(message)
          }
  }
  
  def negativeNumber(response : Int) = {
    val result = response < 0
    if (result) 
      println("I'm afraid, great lord, we have not yet invented negative numbers")
    result
  }
  
  def askBuyLand(bushels : Int , price : Int) = {
    var acresToBuy = -1
    do {
      acresToBuy = readInt("How much land do you want to buy?")
      negativeNumber(acresToBuy)
  
      if (acresToBuy * price > bushels)
        println("I'm afraid, great lord, that we have only " + bushels +
                " and that would cost us " + (acresToBuy * price))          
    }
    while (acresToBuy < 0 || acresToBuy * price > bushels) 
    println("That cost us " + acresToBuy * price + " bushels.")
    acresToBuy
  }
  
  def askSellLand(acres : Int, price : Int) = {
    
    var acresToSell = readInt("How much land do you want to sell?")
    while (acresToSell > acres || 
           acresToSell < 0) {
      negativeNumber(acresToSell)
      if (acresToSell > acres) 
        println("I'm afraid, great lord, that we have only " + acres + " acres")
      acresToSell = readInt("How much land do you want to sell?")
  
    }
    
    println("That gave us "+ price  * acresToSell + " bushels")
    acresToSell
    
  }
  def askFeedPeople(population : Int, bushelsInStorage : Int) = {
    var bushelsToFeed = readInt("How much grain should we feed the people?")
    while (bushelsToFeed < 0 || 
           bushelsToFeed > bushelsInStorage ||
           bushelsToFeed / 20  > population) {
      negativeNumber(bushelsToFeed)
      if (bushelsToFeed > bushelsInStorage) 
        println("We have only " + bushelsInStorage)
      else if (bushelsToFeed / 20  > population) 
        println("We have only "+ population + " and that would feed " + bushelsToFeed / 20)
    bushelsToFeed = readInt("How much grain should we feed the people?")
    }
    bushelsToFeed
  }
  
  def askSowFields(population : Int, bushels : Int , acres : Int) = {
    var acresToSow = readInt("How many acres should we sow?")
    while (acresToSow < 0 ||
           acresToSow > acres ||
           bushels / 2 < acresToSow ||
           population * 10 < acresToSow){
      negativeNumber(acresToSow)
      if (acresToSow > acres) 
        println("I'm afraid we have only " + acres)
      else if (bushels / 2 < acresToSow)
        println("I'm afraid only have enough grain to sow " + (bushels / 2) + " acres")
      else if (population * 10 < acresToSow)
        println("I'm afraid we only have enough people to sow " + (population * 10) + " fields")
      acresToSow = readInt("How many acres should we sow?")
    }
    acresToSow
  }
  
  def plague(population : Int) = {
    if (scala.util.Random.nextInt(100) <= 15)
      population / 2 
    else
      0
  }
      
  def starvation(population : Int, bushels : Int) = {
    scala.math.max(0, population - (bushels / 20))
  }
  
  def immigration(acresOwned : Int, bushelsInStorage : Int, population : Int, starved : Int) = {
    println("Debug: Immigration. Params: "+ acresOwned +"," + bushelsInStorage + "," + population + ", " + starved)
    if (starved > 0){
      println("Debug: starvation. Should return 0")
      0}
    else {
      println("Debug: no starvation. Should return number")
      (20 * acresOwned + bushelsInStorage) / (100 * population) + 1
    }
  }
  
  def assessHarvest() = {
    scala.util.Random.nextInt(7) + 1
  }
  
  def calcHarvest(acresSown : Int, bushelsPerAcre : Int) = {
    acresSown * bushelsPerAcre
  }
  
  def ratProblem(bushelsInStorage : Int) = {
    val random = scala.util.Random
    if (random.nextInt(100) < 40)
      bushelsInStorage / (random.nextInt(2) + 1)
    else
      0
  }
  
  def landPrice() = { scala.util.Random.nextInt(6) + 17}

  
  
  

  def hammurabi() = {
    
    var deaths = 0
    var starved = 0 // how many people starved
    var immigrants = 5 // how many people came to the city
    var population = 100
    var harvest = 3000 // total bushels harvested
    var bushelsPerAcre = 3 // amount harvested for each acre planted
    var rats_ate = 200 // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19 // each acre costs this many bushels
    var plagueDeaths = 0
    var year = 0
    
    
    printIntroductoryMessage()
    
    for (year <- 1 to 10) {
          println("O great Hammurabi!")
          println("You are in year " + year + " of your ten year rule.")
          println("In the previous year " + starved + " people starved to death.")
          println("In the previous year " + immigrants + " people entered the kingdom.")
          println("The population is now " + population + ".")
          println("We harvested " + harvest + " bushels at " + bushelsPerAcre + " bushels per acre.")
          println("Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + "bushels in storage.")
          println("The city owns " + acresOwned + " acres of land.")
          println("Land is currently worth " + pricePerAcre + "bushels per acre.")
          println("There were " + plagueDeaths + " deaths from the plague.")
          println("")
          
          var landBought = askBuyLand(bushelsInStorage, pricePerAcre)
          
          if (landBought == 0) landBought = 0 - askSellLand(acresOwned, pricePerAcre)

          acresOwned += landBought
          bushelsInStorage -= landBought * pricePerAcre
          
          val grainFed  = askFeedPeople(population, bushelsInStorage)
          bushelsInStorage -= grainFed
          
          val acresSown  = askSowFields(population, bushelsInStorage, acresOwned)
          bushelsInStorage -= acresSown * 2
         
          plagueDeaths = plague(population)
          population -= plagueDeaths
          deaths += plagueDeaths
          starved = starvation(population, grainFed)
          population -= starved
          deaths += starved

          
          immigrants = immigration(acresOwned, bushelsInStorage, population, starved)
          population += immigrants
          bushelsPerAcre = assessHarvest()
          
          harvest = calcHarvest(acresSown, bushelsPerAcre)
          bushelsInStorage += harvest
          
          rats_ate = ratProblem(bushelsInStorage)
          bushelsInStorage -= rats_ate
          
          pricePerAcre = landPrice()


    }
    
    println("Deaths: "+deaths + "Acres: "+acresOwned)
               
  }
  
  hammurabi()

  
}