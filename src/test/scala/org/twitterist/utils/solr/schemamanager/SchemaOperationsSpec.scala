package org.twitterist.utils.solr.schemamanager

import org.scalatest.Matchers._
import org.scalatest.{MustMatchers, WordSpec}
import org.twitterist.utils.solr.schemamanager.schema._

class SchemaOperationsSpec extends WordSpec with MustMatchers {

  object SchemaOps extends SchemaOperations {
    override def resetCustomFields(): _root_.org.twitterist.utils.solr.schemamanager.SchemaOperations = {
      this
    }

    override def commit(): _root_.org.twitterist.utils.solr.schemamanager.SchemaOperations = {
      this
    }
  }

  "Method addField" must {
    "be callable multiple times (fluid interface)" in {
      SchemaOps
        .addField("foo", "string", Some("default"), None)
        .addField("bar", "string", Some("default"), None)
        .addField("baz", "string", Some("default"), None) shouldBe a [SchemaOperations]
    }
    "be callable without providing additional field options" in {
      SchemaOps.addField("foo", "string", Some("default")) shouldBe a [SchemaOperations]
    }
    "be callable without providing default value" in {
      SchemaOps.addField("foo", "string") shouldBe a [SchemaOperations]
    }
    "take additional field options" in {
      SchemaOps.addField("foo", "string", None, Some(FieldOptions(indexed = Some(false)))) shouldBe a [SchemaOperations]
    }
  }

  "Method addDynamicField" must {
    "be callable multiple times (fluid interface)" in {
      SchemaOps
        .addDynamicField("foo", "string", Some("default"), None)
        .addDynamicField("bar", "string", Some("default"), None)
        .addDynamicField("baz", "string", Some("default"), None) shouldBe a [SchemaOperations]
    }
    "be callable without providing additional field options" in {
      SchemaOps.addDynamicField("foo", "string", Some("default")) shouldBe a [SchemaOperations]
    }
    "be callable without providing default value" in {
      SchemaOps.addDynamicField("foo", "string") shouldBe a [SchemaOperations]
    }
    "take additional field options" in {
      SchemaOps.addDynamicField("foo", "string", None, Some(FieldOptions(indexed = Some(false)))) shouldBe a [SchemaOperations]
    }
  }
}