package org.twitterist.utils.solr.schemamanager

import org.twitterist.utils.solr.schemamanager.schema._

/**
 * Definition of the operations tasks
 */
trait SchemaOperations {

  protected var fields: List[Field] = List()

  /**
   * Adds a new field definition to schema
   *
   * @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   *
   * @param name The name of the field
   * @param fieldType The type of the field, see https://cwiki.apache.org/confluence/display/solr/Solr+Field+Types
   * @param defaultValue The default value if the field is not filled while indexing
   * @param options Defines additional field options
   */
  def addField(name: String, fieldType: String, defaultValue: Option[String] = None, options: Option[FieldOptions] = None) = {
    fields :+ Field(false, name, fieldType, options)
    this
  }

  /**
   * Adds a new dynamic field rule definition to schema
   *
   * @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   *
   * @param pattern The pattern of the dynamic field (e.g. *_s)
   * @param fieldType The type of the field, see https://cwiki.apache.org/confluence/display/solr/Solr+Field+Types
   * @param defaultValue The default value if the field is not filled while indexing
   * @param options Defines additional field options
   */
  def addDynamicField(pattern: String, fieldType: String, defaultValue: Option[String] = None, options: Option[FieldOptions] = None) = {
    fields :+ Field(true, pattern, fieldType, options)
    this
  }

  /**
   * Commits ensured schema changes to solr
   *
   * @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def commit(): SchemaOperations

  /**
   * Clears staged schema changes instead of commiting them
   *
   * @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def clear(): SchemaOperations = {
    fields = List()
    this
  }

  /**
   * Removes all custom field definitions made by this manager
   *
   * @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def resetCustomFields(): SchemaOperations
}
