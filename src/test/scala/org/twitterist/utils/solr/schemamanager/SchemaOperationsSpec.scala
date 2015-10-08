package org.twitterist.utils.solr.schemamanager

import org.scalatest.Matchers._
import org.scalatest.{ MustMatchers, WordSpec }
import org.twitterist.utils.solr.schemamanager.schema._

class SchemaOperationsSpec extends WordSpec with MustMatchers {

  object SchemaOps extends SchemaOperations {
    override def commit(): _root_.org.twitterist.utils.solr.schemamanager.SchemaOperations = {
      this
    }
  }

  "Method addField" must {
    "be callable multiple times (fluid interface)" in {
      SchemaOps
        .addField("foo", "string", "default", None)
        .addField("bar", "string", "default", None)
        .addField("baz", "string", "default", None) shouldBe a[SchemaOperations]
    }
    "be callable without providing additional field options" in {
      SchemaOps.addField("foo", "string", "default") shouldBe a[SchemaOperations]
    }
    "be callable without providing default value" in {
      SchemaOps.addField("foo", "string") shouldBe a[SchemaOperations]
    }
    "take additional field options" in {

      // specify field options
      val customFieldOptions = FieldOptionContainer(
        indexed = Some(true)
      )

      SchemaOps.addField("foo", "string", "", Some(customFieldOptions)) shouldBe a[SchemaOperations]
    }
  }

  "Method addDynamicField" must {
    "be callable multiple times (fluid interface)" in {
      SchemaOps
        .addDynamicField("foo", "string", "default", None)
        .addDynamicField("bar", "string", "default", None)
        .addDynamicField("baz", "string", "default", None) shouldBe a[SchemaOperations]
    }
    "be callable without providing additional field options" in {
      SchemaOps.addDynamicField("foo", "string", "default") shouldBe a[SchemaOperations]
    }
    "be callable without providing default value" in {
      SchemaOps.addDynamicField("foo", "string") shouldBe a[SchemaOperations]
    }
    "take additional field options" in {

      // specify field options
      val customFieldOptions = FieldOptionContainer(
        indexed = Some(false),
        stored = Some(true)
      )

      SchemaOps.addDynamicField("foo", "string", "", Some(customFieldOptions)) shouldBe a[SchemaOperations]
    }
  }
}