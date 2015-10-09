package org.twitterist.utils.solr.schemamanager

/**
 * Created by frank on 08/10/15.
 */
package object dsl {

  def field(name: String): FieldBuilder = new FieldBuilder(false, name)

  def dynamicField(name: String): FieldBuilder = new FieldBuilder(true, name)

  final class Indexed extends FieldProperty
  final class Stored extends FieldProperty
  final class Required extends FieldProperty

  final val indexed = new Indexed
  final val stored = new Stored
  final val required = new Required
}
