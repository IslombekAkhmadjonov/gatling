package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object chair {
  def openChair(): ChainBuilder = {
    exec(
      http("S01_T06_Open_chair").get(homepage + baseHelpers.modernChair1)
    )
  }

  def addChair(): ChainBuilder = {
    exec(
      http("S01_T07_Add_chair")
        .post(homepage + baseHelpers.ajax)
        .headers(Map(
          "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8"
        ))
        .body(StringBody(
          "action=ic_add_to_cart&add_cart_data=current_product%3D76%26cart_content%3D%257B%252292__%2522%253A12%257D%26current_quantity%3D1&cart_widget=0&cart_container=0"
        ))
    )
  }
}