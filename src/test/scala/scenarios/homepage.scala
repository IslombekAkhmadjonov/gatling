package scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers.thinkTimer

object homepage {
  def openHomepage: ScenarioBuilder = {
    scenario("Homepage")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("Homepage") {
          exec(api.app.openApp())
            .exec(thinkTimer())
        }
        .group("Open Tables"){
          exec(api.tables.openTables())
            .exec(thinkTimer())
        }
        .group("Open table") {
          exec(api.table.openTable())
            .exec(thinkTimer())
        }
        .group("Add table") {
          exec(api.table.addTable())
            .exec(thinkTimer())
        }
      )
    }
}