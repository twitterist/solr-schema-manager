package org.twitterist.utils.solr.schemamanager

import org.twitterist.utils.solr.schemamanager.dsl.FieldBuilder
import org.twitterist.utils.solr.schemamanager.schema._

/** Definition of the operations tasks
 */
trait SchemaOperations {

  /** Holds a list of added field objects
   */
  protected var fields: List[Field] = List()

  /** Adds a new DSL field definition to schema
   *
   *  @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   *
   *  @param fb The field builder instance from the DSL configuration
   *
   *  @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def add(fb: FieldBuilder): SchemaOperations = {
    fields :+ fb.get()
    this
  }

  /** Adds a new field definition to schema
   *
   *  @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   *
   *  @param name The name of the field
   *  @param fieldType The type of the field, see https://cwiki.apache.org/confluence/display/solr/Solr+Field+Types
   *  @param defaultValue The default value if the field is not filled while indexing
   *  @param options Defines additional field options
   *
   *  @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def addField(name: String, fieldType: String, defaultValue: String = "", options: Option[FieldOptions] = None) = {
    fields :+ createField(false, name, fieldType, defaultValue, options)
    this
  }

  /** Adds a new dynamic field rule definition to schema
   *
   *  @see https://cwiki.apache.org/confluence/display/solr/Schema+API#SchemaAPI-AddaNewField
   *
   *  @param pattern The pattern of the dynamic field (e.g. *_s)
   *  @param fieldType The type of the field, see https://cwiki.apache.org/confluence/display/solr/Solr+Field+Types
   *  @param defaultValue The default value if the field is not filled while indexing
   *  @param options Defines additional field options
   *
   *  @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def addDynamicField(pattern: String, fieldType: String, defaultValue: String = "", options: Option[FieldOptions] = None) = {
    fields :+ createField(true, pattern, fieldType, defaultValue, options)
    this
  }

  /** Commits ensured schema changes to solr
   *
   *  @throws SchemaOverrideException If a schema part is going to be overridden and [[Settings.allowOverride]] is set to false
   *  @throws SchemaManagerException If a schema part is going to be overridden and [[Settings.allowOverride]] is set to false
   *  @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def commit(): SchemaOperations

  /** Clears staged schema changes instead of commiting them
   *
   *  @return Own [[SchemaOperations]] instance to ensure fluid interface
   */
  def clear(): SchemaOperations = {
    fields = List()
    this
  }

  /** Helper method to create field instances
   *
   *  @param dynamic If the definition is for a dynamic or static field
   *  @param pattern The pattern of the dynamic field (e.g. *_s)
   *  @param fieldType The type of the field, see https://cwiki.apache.org/confluence/display/solr/Solr+Field+Types
   *  @param defaultValue The default value if the field is not filled while indexing
   *  @param opt Defines additional field options
   *  @return
   */
  private def createField(dynamic: Boolean, pattern: String, fieldType: String, defaultValue: String = "", opt: Option[FieldOptions] = None): Field = {
    opt match {
      case o: Some[FieldOptions] => Field(
        dynamic = dynamic,
        name = pattern,
        fieldType = fieldType,
        defaultValue = defaultValue,
        indexed = o.get.indexed, //TODO: find better option for propperty-mapping
        stored = o.get.stored,
        docValues = o.get.docValues,
        sortMissingFirst = o.get.sortMissingFirst,
        sortMissingLast = o.get.sortMissingLast,
        multiValued = o.get.multiValued,
        omitNorms = o.get.omitNorms,
        omitTermFreqAndPositions = o.get.omitTermFreqAndPositions,
        omitPositions = o.get.omitPositions,
        termVectors = o.get.termVectors,
        termPositions = o.get.termPositions,
        termOffsets = o.get.termOffsets,
        termPayloads = o.get.termPayloads,
        required = o.get.required
      )
      case _ => Field(dynamic = true, name = pattern, fieldType = fieldType)
    }
  }
}
