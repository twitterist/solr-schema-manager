package org.twitterist.utils.solr.schemamanager

/** Package for schema management DSL
 */
package object dsl {

  /** Creates a FieldBuilder instance for a static field
   *
   *  @param name The name of the field
   *  @return a FieldBuilder instance
   */
  def field(name: String): FieldBuilder = new FieldBuilder(false, name)

  /** Creates a FieldBuilder instance for a dynamic field
   *
   *  @param name The name of the field
   *  @return a FieldBuilder instance
   */
  def dynamicField(name: String): FieldBuilder = new FieldBuilder(true, name)

  /** Abstract class for field property definition
   *
   *  @param value The boolean value of the field option
   */
  abstract case class FieldProperty(var value: Boolean = true) extends AnyRef

  /** Field property definition */
  final class Indexed extends FieldProperty

  /** Field property definition */
  final class Stored extends FieldProperty

  /** Field property definition */
  final class Required extends FieldProperty

  /** Field property definition instance to use in DSL */
  final val indexed = new Indexed

  /** Field property definition instance to use in DSL */
  final val stored = new Stored

  /** Field property definition instance to use in DSL */
  final val required = new Required
}
