name := "prediction-service"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.0"

libraryDependencies += "org.hamcrest" % "hamcrest-all" % "1.3"

libraryDependencies += "junit" % "junit" % "4.12"

enablePlugins(JettyPlugin)
