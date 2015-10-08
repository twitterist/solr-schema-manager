package org.twitterist.utils.solr.schemamanager.dsl

import org.scalatest.Matchers._
import org.scalatest.{ MustMatchers, WordSpec }
import org.twitterist.utils.solr.schemamanager.schema.Field
import org.twitterist.utils.solr.schemamanager.dsl._

class DSLSpec extends WordSpec with MustMatchers {

  "Field DSL" must {
    "support static field construction" in {
      field("foo").get() shouldBe a[Field]
      field("foo").get() shouldBe a[Field]
      field("foo").get().name shouldEqual "foo"
      field("foo").get().dynamic shouldEqual false
    }

    "support dynamic field construction" in {
      dynamicField("foo").get() shouldBe a[Field]
      dynamicField("foo").get().name shouldEqual "foo"
      dynamicField("foo").get().dynamic shouldEqual true
    }

    "support field type" in {
      (field("foo") withType "boolean").get() shouldBe a[Field]
      (field("foo") withType "boolean").get().fieldType shouldEqual "boolean"
    }
  }
}