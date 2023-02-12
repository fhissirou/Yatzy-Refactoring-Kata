package org.fodehissirou

import YatzyScoring._

object YatzyKata{
  def score(dices: List[Int], category: YatzyCategory): Int = {
    YatzyScoring(dices).calScore(category)
  }
}