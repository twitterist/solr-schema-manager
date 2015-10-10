package org.twitterist.utils.solr.schemamanager

/** Settings trait for the main schema manager
 */
trait Settings {

  /** The URL of the Solr instance to manage
   */
  val url: String = "http://localhost:8983/solr/gettingstarted"

  /** Supresses [[org.twitterist.utils.solr.schemamanager.SchemaOverrideException]] if some schema part
   *  is going to be overridden
   */
  val allowOverride: Boolean = false
}
