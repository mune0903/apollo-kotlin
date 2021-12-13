plugins {
  id("org.jetbrains.kotlin.jvm")
  id("me.champeau.jmh") version "0.6.6"
}

dependencies {
  implementation("com.apollographql.apollo3:apollo-ast")
  implementation("com.apollographql.apollo3:apollo-compiler")
}

jmh {
  warmupIterations.set(2)
  iterations.set(2)
  fork.set(1)
  resultFormat.set("json")
}
