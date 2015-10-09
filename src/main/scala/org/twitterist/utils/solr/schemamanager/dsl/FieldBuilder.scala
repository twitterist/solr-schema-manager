package org.twitterist.utils.solr.schemamanager.dsl

import org.twitterist.utils.solr.schemamanager.schema.Field

case class FieldProperty(var value: Boolean = true) extends AnyRef

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

  def is(T: FieldProperty): FieldBuilder = {
    T match {
      case fp: Indexed => field.indexed = Some(T.value)
      case fp: Stored => field.stored = Some(T.value)
      case fp: Required => field.required = Some(T.value)
    }
    this
  }

  def isNot(T: FieldProperty): FieldBuilder = {
    T.value = false
    is(T)
    this
  }
}
