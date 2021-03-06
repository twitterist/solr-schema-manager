package org.twitterist.utils.solr.schemamanager

import org.twitterist.utils.solr.schemamanager.schema.Field

/** A schema manager instance
 *
 *  This is the main entry point
 */
case class SchemaManager(
    override val url: String = "http://localhost:8983/solr/gettingstarted",
    override val allowOverride: Boolean = true) extends SchemaOperations with Settings {

  /** @inheritdoc
   */
  override def commit(): SchemaOperations = {

    fields

    throw new SchemaOverrideException()
    this
  }
}
