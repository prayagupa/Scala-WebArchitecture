name := "session-state"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

enablePlugins(JettyPlugin)
