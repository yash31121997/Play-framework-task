name := """PlayProject-task"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.10"

libraryDependencies += guice

libraryDependencies += "com.auth0" % "java-jwt" % "4.3.0"
libraryDependencies += "org.postgresql" % "postgresql" % "42.5.4"

libraryDependencies += "javax.persistence" % "javax.persistence-api" % "2.2"
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"
libraryDependencies += "org.postgresql" % "postgresql" % "42.5.4"
libraryDependencies += "com.typesafe.play" %% "play-jdbc" % "2.8.18"
libraryDependencies += "com.typesafe.play" %% "play-java-forms" % "2.8.18"
libraryDependencies += "com.typesafe.play" %% "play-java-jpa" % "2.8.18"
libraryDependencies ++= Seq(
  javaJpa,
  "org.hibernate" % "hibernate-core" % "5.5.6" // replace by your jpa implementation
)
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.18",
  "com.typesafe.play" %% "play-guice" % "2.8.18"
)
libraryDependencies ++= Seq(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.0",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.0" exclude("com.fasterxml.jackson.core", "jackson-databind")
)
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-mailer" % "8.0.1"
)
libraryDependencies += "com.typesafe.play" %% "play-mailer" % "8.0.1"
libraryDependencies += "com.typesafe.play" %% "play-mailer-guice" % "8.0.1"

libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"
