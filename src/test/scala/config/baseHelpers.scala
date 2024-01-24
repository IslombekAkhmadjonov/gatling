package config

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object baseHelpers {
    val homepage = "http://localhost/"
    val ajax = "wp-admin/admin-ajax.php"
    val tables = "tables/"
    val chairs = "chairs/"
    val kitchenTable1 = "products/kitchen-table1/" 
    val modernChair1 = "products/modern-chair1/"
    val checkout = "checkout/"
    val cart = "cart" 

    def thinkTimer(Min :Int = 2, Max :Int = 5): ChainBuilder = {
        pause(Min, Max)
    }

    val httpProtocol: HttpProtocolBuilder = http
      .inferHtmlResources()
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .doNotTrackHeader("1")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")
      .upgradeInsecureRequestsHeader("1")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-GB,en-US;q=0.9;q=0.8")
}