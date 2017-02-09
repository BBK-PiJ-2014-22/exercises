
package main

/**Represents a traffic light. Red / Amber / Green are valid**/
sealed trait TrafficLight { 
  def next: TrafficLight
}

  
final case object Green extends TrafficLight {
  def next() = Amber
}

final case object Amber extends TrafficLight {
    def next() = Red

}

final case object Red extends TrafficLight{
  def next() = Green
  
}