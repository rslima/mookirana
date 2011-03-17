import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) {
  val liftVersion = "2.2"

  // uncomment the following if you want to use the snapshot repo
  // val scalatoolsSnapshot = ScalaToolsSnapshots

  // If you're using JRebel for Lift development, uncomment
  // this line
  override def scanDirectories = Nil

  val lift =  "net.liftweb" %% "lift-webkit" % liftVersion % "compile"
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test"
  val junit = "junit" % "junit" % "4.8.2" % "test"
  val logback = "ch.qos.logback" % "logback-classic" % "0.9.27"
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.7.2" % "test"
  val rogue = "com.foursquare" % "rogue_2.8.0" % "1.0.4" withSources()

}
