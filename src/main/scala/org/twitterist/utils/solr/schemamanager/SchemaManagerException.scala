package org.twitterist.utils.solr.schemamanager

class SchemaManagerException(msg: String = null, cause: Throwable = null) extends java.lang.Exception(msg, cause) {}

object SchemaManagerException {
  def apply(msg:String) = new SchemaManagerException(msg)
  def apply(msg:String, throwable: Throwable) = new SchemaManagerException(msg, throwable)
}

class SchemaOverrideException(msg: String = null, cause: Throwable = null) extends SchemaManagerException(msg, cause) {}

object SchemaOverrideException {
  def apply(msg:String) = new SchemaOverrideException(msg)
  def apply(msg:String, throwable: Throwable) = new SchemaOverrideException(msg, throwable)
}