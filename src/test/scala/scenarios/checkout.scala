package scenarios

import config.baseHelpers.thinkTimer
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object checkout {
  def openCheckout: ScenarioBuilder = {
    scenario("Open Checkout")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("Open cart") {
          exec(api.cart.openCart())
            .exec(thinkTimer())
        }
        .group("Checkout") {
          exec(api.checkout.checkout())
            .exec(thinkTimer())
        }
        .group("Place order (Country)") {
          exec(api.checkout.placeOrderCountry())
            .exec(thinkTimer())
        }
        .group("Place order (All)") {
          exec(api.checkout.placeOrderAll())
            .exec(thinkTimer())
        }
      )
  }
}