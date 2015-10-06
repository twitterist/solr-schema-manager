package org.twitterist.utils.solr.schemamanager.schema

/**
 * Case class for holding field information
 *
 * @see [[FieldDefinition]]
 * @see [[FieldOptions]]
 */
case class Field(
                  override val dynamic: Boolean,
                  override val name: String,
                  override val fieldType: String,
                  override val defaultValue: String = "",
                  override val indexed: Option[Boolean] = None,
                  override val stored: Option[Boolean] = None,
                  override val docValues: Option[Boolean] = None,
                  override val sortMissingFirst: Option[Boolean] = None,
                  override val sortMissingLast: Option[Boolean] = None,
                  override val multiValued: Option[Boolean] = None,
                  override val omitNorms: Option[Boolean] = None,
                  override val omitTermFreqAndPositions: Option[Boolean] = None,
                  override val omitPositions: Option[Boolean] = None,
                  override val termVectors: Option[Boolean] = None,
                  override val termPositions: Option[Boolean] = None,
                  override val termOffsets: Option[Boolean] = None,
                  override val termPayloads: Option[Boolean] = None,
                  override val required: Option[Boolean] = None
                  ) extends FieldDefinition with FieldOptions

/**
 * Properties for field definitions
 *
 * @see https://cwiki.apache.org/confluence/display/solr/Defining+Fields
 */
sealed trait FieldDefinition {

  /**
   * Indicated whether a field is a dynamic pattern or a static definition
   *
   * @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   * @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaDynamicFieldRule
   */
  val dynamic: Boolean

  /**
   * The name of the field.  Field names should consist of alphanumeric or underscore characters only and not start
   * with a digit. This is not currently strictly enforced, but other field names will not have first class support
   * from all components and back compatibility is not guaranteed. Names with both leading and trailing underscores
   * (e.g. _version_) are reserved. Every field must have a name.
   */
  val name: String

  /**
   * The name of the fieldType for this field. This will be found in the "name" attribute on the fieldType definition.
   * Every field must have a type.
   */
  val fieldType: String

  /**
   * A default value that will be added automatically to any document that does not have a value in this field when it
   * is indexed.  If this property is not specified, there is no default.
   */
  val defaultValue: String = ""
}

/**
 * Override properties for field definitions
 *
 * All of these have default values in Solr if omitted
 *
 * @see https://cwiki.apache.org/confluence/display/solr/Defining+Fields#DefiningFields-OptionalFieldTypeOverrideProperties
 */
trait FieldOptions {

  /**
   * If true, the value of the field can be used in queries to retrieve matching documents
   */
  val indexed: Option[Boolean] = None

  /**
   * If true, the actual value of the field can be retrieved by queries
   */
  val stored: Option[Boolean] = None

  /**
   * If true, the value of the field will be put in a column-oriented DocValues structure
   */
  val docValues: Option[Boolean] = None

  /**
   * Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric
   * fields, including Trie and date fields
   */
  val sortMissingFirst: Option[Boolean] = None

  /**
   * Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric
   * fields, including Trie and date fields
   */
  val sortMissingLast: Option[Boolean] = None

  /**
   * If true, indicates that a single document might contain multiple values for this field type
   */
  val multiValued: Option[Boolean] = None

  /**
   * If true, omits the norms associated with this field (this disables length normalization and index-time boosting
   * for the field, and saves some memory). Defaults to true for all primitive (non-analyzed) field types, such as int,
   * float, data, bool, and string. Only full-text fields or fields that need an index-time boost need norms.
   */
  val omitNorms: Option[Boolean] = None

  /**
   * If true, omits term frequency, positions, and payloads from postings for this field. This can be a performance
   * boost for fields that don't require that information. It also reduces the storage space required for the index.
   * Queries that rely on position that are issued on a field with this option will silently fail to find documents.
   * This property defaults to true for all fields that are not text fields.
   */
  val omitTermFreqAndPositions: Option[Boolean] = None

  /**
   * Similar to omitTermFreqAndPositions but preserves term frequency information
   */
  val omitPositions: Option[Boolean] = None

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  val termVectors: Option[Boolean] = None

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  val termPositions: Option[Boolean] = None

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  val termOffsets: Option[Boolean] = None

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  val termPayloads: Option[Boolean] = None

  /**
   * Instructs Solr to reject any attempts to add a document which does not have a value for this field. This property
   * defaults to false.
   */
  val required: Option[Boolean] = None
}