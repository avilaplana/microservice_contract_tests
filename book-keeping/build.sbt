name := "book-keeping"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  ws,
  "org.scalatest" %% "scalatest" % "2.2.1" % Test,
  "info.cukes" %% "cucumber-scala" % "1.2.4" % Test,
  "info.cukes" % "cucumber-junit" % "1.2.4" % Test,
  "junit" % "junit" % "4.12" % Test,
  "org.scalaj" %% "scalaj-http" % "1.1.4" % Test
)


