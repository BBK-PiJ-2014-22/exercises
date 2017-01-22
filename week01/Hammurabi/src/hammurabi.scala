object hammurabi extends App {
 
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
  

  def hammurabi() = {
    
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
    
    printIntroductoryMessage()
    
    for (year <- 1 to 10) {
          println("O great Hammurabi!")
          println("You are in year " + year + " of your ten year rule.")
          println("In the previous year " + starved + " people starved to death.")
          println("In the previous year " + immigrants + " people entered the kingdom.")
          println("The population is now " + population + ".")
          println("We harvested " + harvest + "bushels at " + bushelsPerAcre + " bushels per acre.")
          println("Rats destroyed " + rats_ate + " bushels, leaving " + bushelsInStorage + "bushels in storage.")
          println("The city owns " + acresOwned + "acres of land.")
          println("Land is currently worth " + pricePerAcre + "bushels per acre.")
          println("There were " + plagueDeaths + " deaths from the plague.")
    }
               
  }
  
  hammurabi()
  println("Check 3")
  
}