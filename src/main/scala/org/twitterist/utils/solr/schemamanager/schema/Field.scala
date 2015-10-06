package org.twitterist.utils.solr.schemamanager.schema

/**
 * Case class for holding field information
 *
 * @param dynamic Wheter the field is a dynamic pattern or a static field definition
 * @param name The name or pattern of the field
 * @param fieldType Internal solr field type
 * @param options Additional options for the field definition
 */
case class Field(dynamic: Boolean, name: String, fieldType: String, options: Option[FieldOptions])
