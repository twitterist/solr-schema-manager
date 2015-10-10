package org.twitterist.utils.solr.schemamanager.client

import org.twitterist.utils.solr.schemamanager.schema._

/** Definition of the http client used to call the SOlr API
 */
trait HttpClient {

  /** Returns the HttpCLient instance
   *
   *  @throws SolrApiUnreachableException In cease of a http timeout calling the API
   *  @return A singleton-ish object instance
   */
  def apply(): HttpClient

  /** Checks if a field exists
   *
   *  @param field The field instance
   *  @throws SolrApiException In cease of an error while communicating with the API
   *  @throws SolrApiUnreachableException In cease of a http timeout calling the API
   *  @return True if the Field exists
   */
  def hasField(field: Field): Boolean

  /** Adds a field to schema
   *
   *  @param field The field instance
   *  @throws SolrApiException In cease of an error while communicating with the API
   *  @throws SolrApiUnreachableException In cease of a http timeout calling the API
   */
  def addField(field: Field): Unit

  /** Updates a field on the schema
   *
   *  @param field The field instance
   *  @throws SolrApiException In cease of an error while communicating with the API
   *  @throws SolrApiUnreachableException In cease of a http timeout calling the API
   */
  def updateField(field: Field): Unit
}
