package config

import com.google.inject.Singleton

@Singleton
class Configuration {
  val customerHost = "http://localhost:9002"
  val accountHost = "http://localhost:9001"
}


