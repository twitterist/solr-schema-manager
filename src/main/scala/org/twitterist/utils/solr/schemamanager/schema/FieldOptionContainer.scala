package org.twitterist.utils.solr.schemamanager.schema

case class FieldOptionContainer(
    override var indexed: Option[Boolean] = None,
    override var required: Option[Boolean] = None,
    override var sortMissingFirst: Option[Boolean] = None,
    override var termPositions: Option[Boolean] = None,
    override var multiValued: Option[Boolean] = None,
    override var stored: Option[Boolean] = None,
    override var termPayloads: Option[Boolean] = None,
    override var omitNorms: Option[Boolean] = None,
    override var docValues: Option[Boolean] = None,
    override var termVectors: Option[Boolean] = None,
    override var termOffsets: Option[Boolean] = None,
    override var omitTermFreqAndPositions: Option[Boolean] = None,
    override var sortMissingLast: Option[Boolean] = None,
    override var omitPositions: Option[Boolean] = None) extends FieldOptions {

}
