package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object cart {
  def openCart(): ChainBuilder = {
    exec(
      http("S01_T08_Open_cart").get(homepage + baseHelpers.cart)
    )
  }
}