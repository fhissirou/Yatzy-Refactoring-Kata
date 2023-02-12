package org.fodehissirou

import scala.collection.immutable.List

case class YatzyScoring(dices: List[Int]) {

  def calScore(category: YatzyCategory): Int = category match {
    case Chance => chanceScore
    case Yatzy => yatzyScore
    case Ones => calOnesToSixes(1)
    case Twos => calOnesToSixes(2)
    case Threes => calOnesToSixes(3)
    case Fours => calOnesToSixes(4)
    case Fives => calOnesToSixes(5)
    case Sixes => calOnesToSixes(6)
    case Pair => pairScore
    case TwoPairs => twoPairsScore
    case ThreeOfAKind => threeOfAKindScore
    case FourOfAKind => fourOfAKindScore
    case SmallStraight => smallStraightScore
    case LargeStraight => largeStraightScore
    case FullHouse => fullHouseScore

  }

  private def chanceScore: Int = dices.sum
  private def yatzyScore: Int = if (dices.distinct.length == 1) 50 else 0

  private def calOnesToSixes(n : Int) : Int = {
    dices.count(_ == n) * n
  }
  private def pairScore: Int = nOfAKindScore(2)
  private def twoPairsScore: Int = {
    val pairs = dices.groupBy(identity).values.filter(_.length >= 2).toList
    if (pairs.length >= 2) pairs.flatten.max * 2 + pairs.flatten.min * 2 else 0
  }
  private def threeOfAKindScore: Int = nOfAKindScore(3)
  private def fourOfAKindScore: Int = nOfAKindScore(4)
  private def nOfAKindScore(n: Int): Int = dices.groupBy(identity).filter(_._2.length >= n).keys.toList.sorted.lastOption.getOrElse(0) * n
  private def smallStraightScore: Int = if (dices.sorted == List(1, 2, 3, 4, 5)) 15 else 0
  private def largeStraightScore: Int = if (dices.sorted == List(2, 3, 4, 5, 6)) 20 else 0
  private def fullHouseScore: Int = {
    val groups = dices.groupBy(identity).values
    if (groups.exists(group => group.size == 2) && groups.exists(group => group.size == 3)) dices.sum else 0
  }

}
