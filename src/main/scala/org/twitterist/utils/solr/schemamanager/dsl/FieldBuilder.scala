package org.twitterist.utils.solr.schemamanager.dsl

import org.twitterist.utils.solr.schemamanager.schema.Field

class FieldBuilder(dynamic: Boolean, name: String) {

  var field: Field = Field(dynamic, name)

  def get(): Field = field

  def withType(t: String): FieldBuilder = {
    field.fieldType = t
    this
  }

  def default(d: String): FieldBuilder = {
    field.defaultValue = d
    this
  }
}
