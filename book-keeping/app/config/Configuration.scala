package config

import com.google.inject.Singleton

@Singleton
class Configuration {
  val customerHost = sys.env.get("DOMAIN_BACKEND_MICROSERVICES").getOrElse("http://localhost:9002")
  val accountHost = sys.env.get("DOMAIN_BACKEND_MICROSERVICES").getOrElse("http://localhost:9001")

}


