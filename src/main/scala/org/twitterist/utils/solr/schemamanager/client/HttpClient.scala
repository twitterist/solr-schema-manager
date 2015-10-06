package org.twitterist.utils.solr.schemamanager.client

import org.twitterist.utils.solr.schemamanager.schema._

trait HttpClient {


  def hasField(field: Field): Boolean

  def addField(field: Field): Unit

  def updateField(field: Field): Unit
}
