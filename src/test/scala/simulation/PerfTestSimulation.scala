package simulation

import config.baseHelpers.httpProtocol
import io.gatling.core.Predef._
import scenarios.homepage.openHomepage
import scenarios.chairs.openChairs
import scenarios.checkout.openCheckout

class PerfTestSimulation extends Simulation {

    // mvn clean
    // mvn gatling:test

    setUp(
        openHomepage.inject(atOnceUsers(100)),
        openChairs.inject(atOnceUsers(50)),
        openCheckout.inject(atOnceUsers(30))
    ).protocols(httpProtocol)
}