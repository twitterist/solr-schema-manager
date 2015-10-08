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
    override var fieldType: String = "string",
    override var defaultValue: String = "",
    override var indexed: Option[Boolean] = None,
    override var stored: Option[Boolean] = None,
    override var docValues: Option[Boolean] = None,
    override var sortMissingFirst: Option[Boolean] = None,
    override var sortMissingLast: Option[Boolean] = None,
    override var multiValued: Option[Boolean] = None,
    override var omitNorms: Option[Boolean] = None,
    override var omitTermFreqAndPositions: Option[Boolean] = None,
    override var omitPositions: Option[Boolean] = None,
    override var termVectors: Option[Boolean] = None,
    override var termPositions: Option[Boolean] = None,
    override var termOffsets: Option[Boolean] = None,
    override var termPayloads: Option[Boolean] = None,
    override var required: Option[Boolean] = None) extends FieldDefinition with FieldOptions {
}

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
  var fieldType: String

  /**
   * A default varue that will be added automatically to any document that does not have a varue in this field when it
   * is indexed.  If this property is not specified, there is no default.
   */
  var defaultValue: String
}

/**
 * Override properties for field definitions
 *
 * All of these have default varues in Solr if omitted
 *
 * @see https://cwiki.apache.org/confluence/display/solr/Defining+Fields#DefiningFields-OptionalFieldTypeOverrideProperties
 */
trait FieldOptions {

  /**
   * If true, the varue of the field can be used in queries to retrieve matching documents
   */
  var indexed: Option[Boolean]

  /**
   * If true, the actual varue of the field can be retrieved by queries
   */
  var stored: Option[Boolean]

  /**
   * If true, the varue of the field will be put in a column-oriented Docvarues structure
   */
  var docValues: Option[Boolean]

  /**
   * Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric
   * fields, including Trie and date fields
   */
  var sortMissingFirst: Option[Boolean]

  /**
   * Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric
   * fields, including Trie and date fields
   */
  var sortMissingLast: Option[Boolean]

  /**
   * If true, indicates that a single document might contain multiple varues for this field type
   */
  var multiValued: Option[Boolean]

  /**
   * If true, omits the norms associated with this field (this disables length normalization and index-time boosting
   * for the field, and saves some memory). Defaults to true for all primitive (non-analyzed) field types, such as int,
   * float, data, bool, and string. Only full-text fields or fields that need an index-time boost need norms.
   */
  var omitNorms: Option[Boolean]

  /**
   * If true, omits term frequency, positions, and payloads from postings for this field. This can be a performance
   * boost for fields that don't require that information. It also reduces the storage space required for the index.
   * Queries that rely on position that are issued on a field with this option will silently fail to find documents.
   * This property defaults to true for all fields that are not text fields.
   */
  var omitTermFreqAndPositions: Option[Boolean]

  /**
   * Similar to omitTermFreqAndPositions but preserves term frequency information
   */
  var omitPositions: Option[Boolean]

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  var termVectors: Option[Boolean]

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  var termPositions: Option[Boolean]

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  var termOffsets: Option[Boolean]

  /**
   * These options instruct Solr to maintain full term vectors for each document, optionally including position, offset
   * and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting
   * and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary
   * for typical uses of Solr.
   */
  var termPayloads: Option[Boolean]

  /**
   * Instructs Solr to reject any attempts to add a document which does not have a varue for this field. This property
   * defaults to false.
   */
  var required: Option[Boolean]
}