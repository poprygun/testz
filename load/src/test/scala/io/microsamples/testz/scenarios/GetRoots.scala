package io.microsamples.testz.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetRoots {

  val getRootsHttp = http("get equation roots")
    .get("/quadratic?a=2&b=6&c=4")
    .check(status is 200)

  val getRoots = scenario("Get Equation Roots")
    .exec(getRootsHttp)
}
