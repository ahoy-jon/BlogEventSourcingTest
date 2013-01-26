import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "ouch"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
     javaJdbc,
    "org.scala-stm" %% "scala-stm" % "0.7",
     "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
