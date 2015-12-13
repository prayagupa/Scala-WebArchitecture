package com.prediction.service

import scala.util.Random

/**
 * Created by prayagupd
 * on 11/27/15.
 */

class PredictService {
  def checkPrediction(number: Int, value: Int) : String = {
    if(number < value) {
      return "Sorry, too low prediction"
    }

    if(number > value) {
      return "Sorry, too high prediction"
    }

    return "Perfect. You won a trip to Mountainous Nepal"
  }


  def random(range : Range = 1 to 10) : Int = {
    val random = new Random
    range(random.nextInt(range length))
  }

}
