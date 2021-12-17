package com.apollographql.apollo3.compiler.fragmentKeyfields

import com.apollographql.apollo3.annotations.ApolloExperimental
import com.apollographql.apollo3.ast.GQLFragmentDefinition
import com.apollographql.apollo3.ast.GQLOperationDefinition
import com.apollographql.apollo3.ast.checkKeyFields
import com.apollographql.apollo3.ast.parseAsGQLDocument
import com.apollographql.apollo3.ast.transformation.addRequiredFields
import com.apollographql.apollo3.compiler.introspection.toSchema
import okio.buffer
import okio.source
import org.junit.Assert.fail
import org.junit.Test
import java.io.File

@OptIn(ApolloExperimental::class)
class FragmentKeyFieldsTest {
  @Test
  fun test() {
    val schema = File("src/test/kotlin/com/apollographql/apollo3/compiler/fragmentKeyfields/schema.graphqls").toSchema()
    val definitions = File("src/test/kotlin/com/apollographql/apollo3/compiler/fragmentKeyfields/operations.graphql")
        .source()
        .buffer()
        .parseAsGQLDocument()
        .valueAssertNoErrors()
        .definitions
    val operation = definitions.filterIsInstance<GQLOperationDefinition>()
        .first()

    val fragments = definitions.filterIsInstance<GQLFragmentDefinition>()

    /**
     * throws with:
     * Key Field(s) '[isbn]' are not queried on Book at Operation(GetBook).book
     *
     *
     */
   checkKeyFields(operation, schema, fragments.associateBy { it.name })
  }
}
