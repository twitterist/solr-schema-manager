package org.twitterist.utils.solr.schemamanager


/**
 * A schema manager instance
 *
 * This is the main entry point
 */
case class SchemaManager(
  override val apiEndpoint: String = "http://localhost:8983/solr/gettingstarted",
  override val warnOnDefinitionOverride: Boolean = true
) extends SchemaOperations with Settings {

  /**
   * @inheritdoc
   */
  override def commit(): SchemaOperations = {
    //TODO: implementation
    this
  }
}
