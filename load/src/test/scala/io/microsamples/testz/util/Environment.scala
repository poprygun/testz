package io.microsamples.testz.util

import java.util

object Environment {
  val baseURL = scala.util.Properties.envOrElse("baseURL", "http://localhost:8080")
  val users = scala.util.Properties.envOrElse("numberOfUsers", "5000")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "5000") // in milliseconds

}
