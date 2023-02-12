package org.fodehissirou

import YatzyKata.*

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class YatzyTests extends AnyFunSuite with Matchers {


  test("Chance")  {
    assert(YatzyKata.score(List(2, 3, 4, 5, 1), Chance) == 15)
    assert(YatzyKata.score(List(3, 3, 4, 5, 1), Chance)== 16)
    assert(YatzyKata.score(List(1, 1, 3, 3, 6), Chance) == 14)
    assert(YatzyKata.score(List(4, 5, 5, 6, 1), Chance) == 21)
  }

  test("yatzy") {
    assert(YatzyKata.score(List(4, 4, 4, 4, 4), Yatzy) == 50)
    assert(YatzyKata.score(List(6, 6, 6, 6, 6), Yatzy) == 50)
    assert(YatzyKata.score(List(6, 6, 6, 6, 3), Yatzy) == 0)
    assert(YatzyKata.score(List(1, 1, 1, 1, 1), Yatzy) == 50)
    assert(YatzyKata.score(List(1, 1, 1, 2, 1), Yatzy) == 0)
  }

  test("ones") {
    assert(YatzyKata.score(List(1, 2, 3, 4, 5), Ones) == 1)
    assert(YatzyKata.score(List(1, 2, 1, 4, 5), Ones) == 2)
    assert(YatzyKata.score(List(6, 2, 2, 4, 5), Ones) == 0)
    assert(YatzyKata.score(List(1, 2, 1, 1, 1), Ones) == 4)
    assert(YatzyKata.score(List(3, 3, 3, 4, 5), Ones) == 0)
  }

  test("twos") {
    assert(YatzyKata.score(List(1, 2, 3, 2, 6), Twos) == 4)
    assert(YatzyKata.score(List(2, 2, 2, 2, 2), Twos) == 10)
    assert(YatzyKata.score(List(2, 3, 2, 5, 1), Twos) == 4)
  }

  test("Threes") {
    assert(YatzyKata.score(List(1, 2, 3, 2, 3), Threes) == 6)
    assert(YatzyKata.score(List(2, 3, 3, 3, 3), Threes) == 12)
  }

  test("fours") {
    assert(YatzyKata.score(List(4, 4, 4, 5, 5), Fours) == 12)
    assert(YatzyKata.score(List(4, 4, 5, 5, 5), Fours) == 8)
    assert(YatzyKata.score(List(4, 5, 5, 5, 5), Fours) == 4)
    assert(YatzyKata.score(List(1, 1, 2, 4, 4), Fours) == 8)
  }

  test("fives")  {
    assert(YatzyKata.score(List(4, 4, 4, 5, 5), Fives) == 10)
    assert(YatzyKata.score(List(4, 4, 5, 5, 5), Fives) == 15)
    assert(YatzyKata.score(List(4, 5, 5, 5, 5), Fives) == 20)
  }

  test("sixes") {
    assert(YatzyKata.score(List(4, 4, 4, 5, 5), Sixes) == 0)
    assert(YatzyKata.score(List(4, 4, 6, 5, 5), Sixes) == 6)
    assert(YatzyKata.score(List(6, 5, 6, 6, 5), Sixes) == 18)
  }

  test("pair") {
    assert(YatzyKata.score(List(3, 4, 3, 5, 6), Pair) == 6)
    assert(YatzyKata.score(List(5, 3, 3, 3, 5), Pair) == 10)
    assert(YatzyKata.score(List(5, 3, 6, 6, 5), Pair) == 12)
    assert(YatzyKata.score(List(1, 2, 3, 4, 5), Pair) == 0)
    assert(YatzyKata.score(List(3, 3, 3, 4, 4), Pair) == 8)
    assert(YatzyKata.score(List(1, 1, 6, 2, 6), Pair) == 12)
    assert(YatzyKata.score(List(3, 3, 3, 4, 1), Pair) == 6)
    assert(YatzyKata.score(List(3, 3, 3, 3, 1), Pair) == 6)
  }

  test("twoPairs") {
    assert(YatzyKata.score(List(3, 3, 5, 4, 5), TwoPairs) == 16)
    assert(YatzyKata.score(List(3, 3, 5, 5, 5), TwoPairs) == 16)
    assert(YatzyKata.score(List(1, 1, 2, 3, 3), TwoPairs) == 8)
    assert(YatzyKata.score(List(1, 1, 2, 3, 4), TwoPairs) == 0)
    assert(YatzyKata.score(List(1, 1, 2, 2, 2), TwoPairs) == 6)
    assert(YatzyKata.score(List(3, 3, 3, 3, 1), TwoPairs) == 0)
  }

  test("threeOfAKind") {
    assert(YatzyKata.score(List(3, 3, 3, 4, 5), ThreeOfAKind) == 9)
    assert(YatzyKata.score(List(5, 3, 5, 4, 5), ThreeOfAKind) == 15)
    assert(YatzyKata.score(List(3, 3, 3, 3, 5), ThreeOfAKind) == 9)
    assert(YatzyKata.score(List(3, 3, 3, 3, 3), ThreeOfAKind) == 9)
    assert(YatzyKata.score(List(3, 3, 4, 5, 6), ThreeOfAKind) == 0)
    assert(YatzyKata.score(List(3, 3, 3, 3, 1), ThreeOfAKind) == 9)
  }

  test("FourOfAKind") {
    assert(YatzyKata.score(List(3, 3, 3, 3, 5), FourOfAKind) == 12)
    assert(YatzyKata.score(List(5, 5, 5, 4, 5), FourOfAKind) == 20)
    assert(YatzyKata.score(List(2, 2, 2, 2, 5), FourOfAKind) == 8)
    assert(YatzyKata.score(List(2, 2, 2, 5, 5), FourOfAKind) == 0)
    assert(YatzyKata.score(List(2, 2, 2, 2, 2), FourOfAKind) == 8)
  }

  test("smallStraight"){
    assert(YatzyKata.score(List(1, 2, 3, 4, 5), SmallStraight) == 15)
    assert(YatzyKata.score(List(2, 3, 4, 5, 1), SmallStraight) == 15)
    assert(YatzyKata.score(List(1, 2, 2, 4, 5), SmallStraight) == 0)
  }

  test("largeStraight"){
    assert(YatzyKata.score(List(6, 2, 3, 4, 5), LargeStraight) == 20)
    assert(YatzyKata.score(List(2, 3, 4, 5, 6), LargeStraight) == 20)
    assert(YatzyKata.score(List(1, 2, 2, 4, 5), LargeStraight) == 0)
  }

  test("fullHouse"){
    assert(YatzyKata.score(List(6, 2, 2, 2, 6), FullHouse) == 18)
    assert(YatzyKata.score(List(2, 3, 4, 5, 6), FullHouse) == 0)

    assert(YatzyKata.score(List(1, 1, 2, 2, 2), FullHouse) == 8)
    assert(YatzyKata.score(List(2, 2, 3, 3, 4), FullHouse) == 0)
    assert(YatzyKata.score(List(4, 4, 4, 4, 4), FullHouse) == 0)
  }

}