package org.twitterist.utils.solr.schemamanager.client

class ApiException(msg: String = null, cause: Throwable = null) extends java.lang.Exception(msg, cause) {}

object ApiException {
  def apply(msg: String) = new ApiException(msg)
  def apply(msg: String, throwable: Throwable) = new ApiException(msg, throwable)
}

class ApiUnreachableException(msg: String = null, cause: Throwable = null) extends ApiException(msg, cause) {}

object ApiUnreachableException {
  def apply(msg: String) = new ApiUnreachableException(msg)
  def apply(msg: String, throwable: Throwable) = new ApiUnreachableException(msg, throwable)
}
