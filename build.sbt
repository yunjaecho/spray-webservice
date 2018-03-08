name := "spray-webservice"

version := "1.0"

scalaVersion := "2.11.6"

val akka = "2.3.11"
val spray = "1.3.3"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Spray Repository" at "http://repo.spray.io")
libraryDependencies ++=
  Seq(
    // -- Logging --
    "ch.qos.logback"    %  "logback-classic" % "1.2.3",
    //"ch.qos.logback" % "logback-classic" % "1.1.2",
    //"com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
    // -- Akka --
    "com.typesafe.akka" %% "akka-testkit" % akka % "test",
    "com.typesafe.akka" %% "akka-actor" % akka,
    "com.typesafe.akka" %% "akka-slf4j" % akka,
    // -- Spray --
    "io.spray" %% "spray-routing" % spray,
    "io.spray" %% "spray-json" % spray,
    "io.spray" %% "spray-client" % spray,
    "io.spray" %% "spray-testkit" % spray % "test"
    // -- json --
    //"io.spray" %% "spray-json" % "1.3.1",
    // -- config --
    //"com.typesafe" % "config" % "1.2.1",
  )