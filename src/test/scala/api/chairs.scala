package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object chairs {
  def openChairs(): ChainBuilder = {
    exec(
      http("S01_T05_Open_Chairs").get(homepage + baseHelpers.chairs)
    )
  }
}