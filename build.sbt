name := "spatialdatagen"

scalaVersion := "2.12.1"

lazy val setm = (project in file("setm"))

lazy val root = (project in file(".")).dependsOn(setm)



libraryDependencies ++= Seq(
   "org.scalatest" %% "scalatest" % "3.0.1" % "test" withSources(),
   "org.scalacheck" %% "scalacheck" % "1.13.4" % "test" ,
   "com.github.scopt" %% "scopt" % "3.5.0"
)

test in assembly := {}
logBuffered in Test := false

parallelExecution in Test := false

mainClass in (Compile, packageBin) := Some("dbis.datagen.Generator")

mainClass in (Compile, run) := Some("dbis.datagen.Generator")

mainClass in assembly := Some("dbis.datagen.Generator")

assemblyJarName in assembly := s"${name.value}.jar"

// assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
