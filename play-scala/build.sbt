name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "net.sf.barcode4j" % "barcode4j" % "2.0",
  "com.typesafe.slick" %% "slick" % "2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)


