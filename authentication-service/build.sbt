name := "authorisation-service"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies += "com.lmax" % "disruptor" % "3.3.0"

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.5"

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.5"

libraryDependencies += "org.apache.logging.log4j" % "log4j-web" % "2.5"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.0"

//
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

enablePlugins(JettyPlugin)

containerPort := 9090
