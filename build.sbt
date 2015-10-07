name := """solr-schema-manager"""
organization := "org.twitterist"
version := "0.0.1"
description:= "A schema manager for Apache Solr written in Scala. Utilizes the Solr 5 schema api to create and update schema definitions"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")
scalaVersion := "2.10.4"
crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0-M9" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
)

GithubRelease.repo := "twitterist/solr-schema-manager"
GithubRelease.prerelease := true

bintrayOrganization := Some("twitterist")
bintrayRepository := "maven"
bintrayReleaseOnPublish in ThisBuild := false

com.typesafe.sbt.SbtGit.versionWithGit

scalariformSettingsWithIt