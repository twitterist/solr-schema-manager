package org.twitterist.utils.solr.schemamanager.schema

/**
 * Override properties for field definitions
 *
 * All of these have default values in Solr if omitted
 *
 * @see https://cwiki.apache.org/confluence/display/solr/Defining+Fields#DefiningFields-OptionalFieldTypeOverrideProperties
 *
 * @param indexed If true, the value of the field can be used in queries to retrieve matching documents
 * @param stored If true, the actual value of the field can be retrieved by queries
 * @param docValues If true, the value of the field will be put in a column-oriented DocValues structure
 * @param sortMissingFirst Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric fields, including Trie and date fields
 * @param sortMissingLast Control the placement of documents when a sort field is not present. As of Solr 3.5, these work for all numeric fields, including Trie and date fields
 * @param multiValued If true, indicates that a single document might contain multiple values for this field type
 * @param omitNorms If true, omits the norms associated with this field (this disables length normalization and index-time boosting for the field, and saves some memory). Defaults to true for all primitive (non-analyzed) field types, such as int, float, data, bool, and string. Only full-text fields or fields that need an index-time boost need norms.
 * @param omitTermFreqAndPositions If true, omits term frequency, positions, and payloads from postings for this field. This can be a performance boost for fields that don't require that information. It also reduces the storage space required for the index. Queries that rely on position that are issued on a field with this option will silently fail to find documents. This property defaults to true for all fields that are not text fields.
 * @param omitPositions Similar to omitTermFreqAndPositions but preserves term frequency information
 * @param termVectors These options instruct Solr to maintain full term vectors for each document, optionally including position, offset and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary for typical uses of Solr.
 * @param termPositions These options instruct Solr to maintain full term vectors for each document, optionally including position, offset and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary for typical uses of Solr.
 * @param termOffsets These options instruct Solr to maintain full term vectors for each document, optionally including position, offset and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary for typical uses of Solr.
 * @param termPayloads These options instruct Solr to maintain full term vectors for each document, optionally including position, offset and payload information for each term occurrence in those vectors. These can be used to accelerate highlighting and other ancillary functionality, but impose a substantial cost in terms of index size. They are not necessary for typical uses of Solr.
 * @param required Instructs Solr to reject any attempts to add a document which does not have a value for this field. This property defaults to false.
 */
case class FieldOptions(
                                    indexed: Option[Boolean] = None,
                                    stored: Option[Boolean] = None,
                                    docValues: Option[Boolean] = None,
                                    sortMissingFirst: Option[Boolean] = None,
                                    sortMissingLast: Option[Boolean] = None,
                                    multiValued: Option[Boolean] = None,
                                    omitNorms: Option[Boolean] = None,
                                    omitTermFreqAndPositions: Option[Boolean] = None,
                                    omitPositions: Option[Boolean] = None,
                                    termVectors: Option[Boolean] = None,
                                    termPositions: Option[Boolean] = None,
                                    termOffsets: Option[Boolean] = None,
                                    termPayloads: Option[Boolean] = None,
                                    required: Option[Boolean] = None
                                    )
