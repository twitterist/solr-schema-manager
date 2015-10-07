package org.twitterist.utils.solr.schemamanager.client

private[schemamanager] object DispatchHttpClient extends HttpClient {

  def apply() = DispatchHttpClient

  def addField(field: org.twitterist.utils.solr.schemamanager.schema.Field): Unit = {

  }

  def hasField(field: org.twitterist.utils.solr.schemamanager.schema.Field): Boolean = {
    true
  }

  def updateField(field: org.twitterist.utils.solr.schemamanager.schema.Field): Unit = {

  }
}
