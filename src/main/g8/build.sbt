name := "$name$"

scalaVersion := "2.12.3"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.3" % Test
)
scalacOptions ++= Seq("-deprecation", "-feature")
scalafmtOnCompile in ThisBuild := true
