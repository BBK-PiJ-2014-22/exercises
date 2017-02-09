
package main

/**Represents a traffic light. Red / Amber / Green are valid**/
sealed trait TrafficLight { 
  
  final case object Green extends TrafficLight //final makes it so it is impossible to extend Green etc
  final case object Amber extends TrafficLight
  final case object Red extends TrafficLight
  
  def nextPoly() = {
        
  }
  
  def nextPattern(a : TrafficLight) : TrafficLight = {
    case Red => Green
    case Green => Amber
    case Amber => Red
  }
  
}