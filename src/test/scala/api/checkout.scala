package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object checkout {
  def checkout(): ChainBuilder = {
    exec(
      http("S01_T09_Checkout").get(homepage + baseHelpers.checkout)
    )
  }

  def placeOrderCountry(): ChainBuilder = {
    exec(
      http("S01_T10_S01_Place_order(Country)")
        .post(homepage + baseHelpers.ajax)
        .headers(Map(
          "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8"
        ))
        .body(StringBody(
          "action=ic_state_dropdown&country_code=UZ&state_code="
        ))
    )
  }

  def placeOrderAll(): ChainBuilder = {
    exec(
      http("S01_T10_S02_Place_order(All)")
        .post(homepage + baseHelpers.checkout)
        .headers(Map(
          "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
        ))
        .body(StringBody(
          "cart_content:{\"92__\":1,\"76__\":1}\nproduct_price_92__:200.00\nproduct_price_76__:124.00\ntotal_net:324.00\ntrans_id:17005016603932\nshipping:order\ncart_content:{\"92__\":1,\"76__\":1}\ncart_type:order\ncart_name:asdf\ncart_address:asdf\ncart_postal:asdf\ncart_city:asdf\ncart_country:UZ\ncart_phone:123\ncart_email:asdf@gmail.com\ncart_submit:Place Order",
        ))
    )
  }
}