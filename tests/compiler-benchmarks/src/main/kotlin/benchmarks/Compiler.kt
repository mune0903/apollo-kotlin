@file:Suppress("EXPERIMENTAL_API_USAGE")

package benchmarks

import com.apollographql.apollo3.compiler.ApolloCompiler
import com.apollographql.apollo3.compiler.MODELS_RESPONSE_BASED
import com.apollographql.apollo3.compiler.Options
import com.apollographql.apollo3.compiler.TargetLanguage
import java.io.File

//private const val PROJECT_FOLDER = "compiler-benchmarks/"
private const val PROJECT_FOLDER = ""

class Compiler {

  fun compilerWrite() {
    val folder = File("${PROJECT_FOLDER}src/main/graphql")
    val options = options(folder, MODELS_RESPONSE_BASED)
    options.outputDir.deleteRecursively()
    ApolloCompiler.write(options)
  }

  private fun options(folder: File, codegenModels: String): Options {
    val schemaFile = File(folder, "schema.graphqls")
    val graphqlFiles = setOf(File(folder, "operations.graphql"))

    return Options(
        executableFiles = graphqlFiles,
        schemaFile = schemaFile,
        outputDir = File("${PROJECT_FOLDER}build/generated/${folder.name}/kotlin/$codegenModels/"),
        packageName = "com.example.${folder.name}"
    ).copy(
        codegenModels = codegenModels,
        moduleName = folder.name,
        targetLanguage = TargetLanguage.KOTLIN_1_5,
    )
  }
}

fun main() {
  Compiler().compilerWrite()
}
