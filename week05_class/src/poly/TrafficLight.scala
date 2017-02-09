
package poly

/**Represents a traffic light. Red / Amber / Green are valid**/
//polymorphic
//sealed trait TrafficLight { 
//  def next: TrafficLight
//}
//  
//final case object Green extends TrafficLight {
//  def next() = Amber
//}
//
//final case object Amber extends TrafficLight {
//    def next() = Red
//
//}
//
//final case object Red extends TrafficLight{
//  def next() = Green
//  
//}


sealed trait TrafficLight {
  def next: TrafficLight = {
    this match {
      case Green => Amber
      case Amber => Red
      case Red => Green
      //case _ => Anything - the _ is the wild card can can be useful at the end to catch remainder
    }
  }
}

final case object Green extends TrafficLight
final case object Red extends TrafficLight
final case object Amber extends TrafficLight
