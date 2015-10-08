package org.twitterist.utils.solr.schemamanager

/**
 * Created by frank on 08/10/15.
 */
package object dsl {

  def field(name: String): FieldBuilder = new FieldBuilder(false, name)

  def dynamicField(name: String): FieldBuilder = new FieldBuilder(true, name)
}
