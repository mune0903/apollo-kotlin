// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_hardcoded

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  /**
   * Represents a review for a movie
   */
  data class Review(
    val __typename: String = "Review",
    /**
     * The number of stars this review gave, 1-5
     */
    val stars: Int,
    /**
     * Comment about the movie
     */
    val commentary: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Review.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@Review.stars)
      writer.writeString(RESPONSE_FIELDS[2], this@Review.commentary)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("stars", "stars", null, false, null),
          ResponseField.forString("commentary", "commentary", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Review = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val stars = readInt(RESPONSE_FIELDS[1])!!
        val commentary = readString(RESPONSE_FIELDS[2])
        Review(
          __typename = __typename,
          stars = stars,
          commentary = commentary
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Review> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val reviews: List<Review?>?,
    val testNullableArguments: Int
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeList(RESPONSE_FIELDS[0], this@Data.reviews) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
      writer.writeInt(RESPONSE_FIELDS[1], this@Data.testNullableArguments)
    }

    fun reviewsFilterNotNull(): List<Review>? = reviews?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forList("reviews", "reviews", mapOf<String, Any?>(
            "episode" to "JEDI",
            "starsInt" to "10",
            "starsFloat" to "9.9"), true, null),
          ResponseField.forInt("testNullableArguments", "testNullableArguments", mapOf<String,
              Any?>(
            "int" to null,
            "string" to null,
            "float" to null,
            "review" to null,
            "episode" to null,
            "boolean" to null,
            "list" to null), false, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val reviews = readList<Review>(RESPONSE_FIELDS[0]) { reader ->
          reader.readObject<Review> { reader ->
            Review(reader)
          }
        }
        val testNullableArguments = readInt(RESPONSE_FIELDS[1])!!
        Data(
          reviews = reviews,
          testNullableArguments = testNullableArguments
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "c079dafcee21e2ecf99031bb06e515f069e661513cedaea29191c98b566125d6"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  reviews(episode: JEDI, starsInt: 10, starsFloat: 9.9) {
          |    __typename
          |    stars
          |    commentary
          |  }
          |  testNullableArguments(int: null, string: null, float: null, review: null, episode: null, boolean: null, list: null)
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
