package org.fodehissirou

sealed trait YatzyCategory

case object Chance extends YatzyCategory
case object Yatzy extends YatzyCategory
case object Ones extends YatzyCategory
case object Twos extends YatzyCategory
case object Threes extends YatzyCategory
case object Fours extends YatzyCategory
case object Fives extends YatzyCategory
case object Sixes extends YatzyCategory
case object Pair extends YatzyCategory
case object TwoPairs extends YatzyCategory
case object ThreeOfAKind extends YatzyCategory
case object FourOfAKind extends YatzyCategory
case object SmallStraight extends YatzyCategory
case object LargeStraight extends YatzyCategory
case object FullHouse extends YatzyCategory
