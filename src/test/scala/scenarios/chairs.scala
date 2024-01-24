package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers.thinkTimer

object chairs {
  def openChairs: ScenarioBuilder = {
    scenario("Open Chairs")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("Open Chairs") {
          exec(api.chairs.openChairs())
            .exec(thinkTimer())
        }
        .group("Open chair") {
          exec(api.chair.openChair())
            .exec(thinkTimer())
        }
        .group("Add chair") {
          exec(api.chair.addChair())
            .exec(thinkTimer())
        }
      )
  }
}