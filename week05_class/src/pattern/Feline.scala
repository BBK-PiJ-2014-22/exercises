package pattern

import poly.Food

sealed trait Feline {
  def dinner: Food = {
    this match {
      case Lion() => poly.Antelope()
      case Cat() => poly.Mice()
      case Panther() => poly.Licorice()
      case Tiger() => poly.TigerFood()
    }
  }
}

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline 
final case class Cat() extends Feline 