package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers.homepage

object app {
  def openApp(): ChainBuilder = {
    exec(
      http("S01_T01_Open_app").get(homepage)
        .check(
          status.is(200)
        )
    )
  }
}