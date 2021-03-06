import sbt._
import sbt.Keys._

object LiftProjectBuild extends Build {

  import BuildSettings._

  lazy val root = Project("mapa-martadero", file("."))
    .settings(liftAppSettings: _*)
    .settings(libraryDependencies ++=
      Seq(
        "net.liftweb" %% "lift-webkit" % Ver.lift % "compile",
        "net.liftweb" %% "lift-mongodb-record" % Ver.lift % "compile",
        "net.liftmodules" %% ("mongoauth_"+Ver.lift_edition) % "0.4" % "compile",
        "net.liftmodules" %% ("extras_"+Ver.lift_edition) % "0.3" % "compile",
        "net.liftweb" %% "lift-squeryl-record" % Ver.lift % "compile",
        "org.eclipse.jetty" % "jetty-webapp" % Ver.jetty % "container",
        "ch.qos.logback" % "logback-classic" % "1.0.13" % "compile",
        "org.scalatest" %% "scalatest" % "1.9.2" % "test",
        "com.foursquare" %% "rogue-lift" % "2.2.0",
        "mysql" % "mysql-connector-java" % "5.1.6",
        "org.quartz-scheduler" % "quartz" % "2.2.1"
      )
    )
}
