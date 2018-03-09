name := "spray-webservice"

version := "1.0"

scalaVersion := "2.11.5"

val akkaVersion = "2.3.9"
val sprayVersion = "1.3.2"
val Json4sVersion = "3.2.11"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Spray Repository" at "http://repo.spray.io")
libraryDependencies ++=
  Seq(
    "com.typesafe.akka" %% "akka-actor"      % akkaVersion,
    "io.spray"          %% "spray-can"       % sprayVersion,
    "io.spray"          %% "spray-routing"   % sprayVersion,
    "io.spray"          %% "spray-json"      % "1.3.1",
    "com.typesafe.akka" %% "akka-slf4j"      % akkaVersion,
    "ch.qos.logback"    %  "logback-classic" % "1.1.2",
    "org.json4s"        %% "json4s-native" % Json4sVersion,
    "org.json4s"        %% "json4s-ext" % Json4sVersion,
    "com.typesafe.akka" %% "akka-testkit"    % akkaVersion  % "test",
    "io.spray"          %% "spray-testkit"   % sprayVersion % "test",
    "org.specs2"        %% "specs2"          % "2.3.13"     % "test"
  )

// Assembly settings
mainClass in Global := Some("com.yunjae.spray.quiz.ApplicationMain")
