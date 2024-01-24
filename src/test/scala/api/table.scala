package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object table {

  def openTable():ChainBuilder = {
    exec(
      http("S01_T03_Open_table").get(homepage + baseHelpers.kitchenTable1)
    )
  }

  def addTable(): ChainBuilder = {
    exec(
      http("S01_T04_Add_table")
        .post(homepage + baseHelpers.ajax)
        .headers(Map(
          "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8"
        ))
        .body(StringBody(
          "action=ic_add_to_cart&add_cart_data=current_product%3D92%26cart_content%3D%26current_quantity%3D1&cart_widget=0&cart_container=0"
        ))
    )
  }
}