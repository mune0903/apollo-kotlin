package benchmarks

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class CompilerBenchmark {
  @Benchmark
  fun compilerWrite() {
    Compiler().compilerWrite()
  }
}
