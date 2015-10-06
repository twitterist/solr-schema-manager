package org.twitterist.utils.solr.schemamanager

/**
 * Settings trait for the main schema manager
 */
trait Settings {

  /**
   * The URL of the Solr instance to manage
   */
  val apiEndpoint: String = "http://localhost:8983/solr/gettingstarted"

  /**
   * Throw a warning when definitions (like fields) are beeing overriden
   */
  val warnOnDefinitionOverride: Boolean = true
}
