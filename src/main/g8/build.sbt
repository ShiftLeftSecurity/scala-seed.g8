name := "$name$"
organization := "io.shiftleft"

scalaVersion := "2.12.6"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.3" % Test
)
scalacOptions ++= Seq("-deprecation", "-feature")
ThisBuild/scalafmtOnCompile := true
ThisBuild/scalafmtFailTest := false
Test/fork := true
updateOptions := updateOptions.value.withLatestSnapshots(false)
updateOptions := updateOptions.value.withCachedResolution(true)

coursierTtl := None //always check for updated snapshots
resolvers ++= Seq(
  Resolver.mavenLocal,
  "Artifactory snapshot local" at "https://shiftleft.jfrog.io/shiftleft/libs-snapshot-local",
  "Artifactory release local" at "https://shiftleft.jfrog.io/shiftleft/libs-release-local",
  "Apache public" at "https://repository.apache.org/content/groups/public/",
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/public",
  "Bedatadriven for SOOT dependencies" at "https://nexus.bedatadriven.com/content/groups/public"
)

publishLocal := publishM2.value // always publish to local maven cache to avoid having to look in too many places when debugging
publishTo := {
  val jfrog = "https://shiftleft.jfrog.io/shiftleft/"
  if (isSnapshot.value)
    Some("snapshots" at jfrog + "libs-snapshot-local")
  else
    Some("releases"  at jfrog + "libs-release-local")
}
publishMavenStyle := true
crossPaths := false
