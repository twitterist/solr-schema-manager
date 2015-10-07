package org.twitterist.utils.solr.schemamanager.client

import org.twitterist.utils.solr.schemamanager.schema.Field

/**
 * Client implementation base on the Dispatch http client
 *
 * This is the default http client implementation used
 *
 * @see http://dispatch.databinder.net/Dispatch.html
 */
private[schemamanager] object DispatchHttpClient extends HttpClient {

  /**
   * @inheritdoc
   */
  override def apply() = DispatchHttpClient

  /**
   * @inheritdoc
   */
  override def addField(field: Field): Unit = {

  }

  /**
   * @inheritdoc
   */
  override def hasField(field: Field): Boolean = {
    true
  }

  /**
   * @inheritdoc
   */
  override def updateField(field: Field): Unit = {

  }
}
