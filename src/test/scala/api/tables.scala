package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import config.baseHelpers
import config.baseHelpers.homepage

object tables {
    def openTables(): ChainBuilder = {
        exec(
            http("S01_T02_Open_Tables").get(homepage + baseHelpers.tables)
        )
    }
}