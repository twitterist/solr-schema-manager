package org.twitterist.utils.solr.schemamanager.dsl

import org.scalatest.Matchers._
import org.scalatest.{MustMatchers, WordSpec}
import org.twitterist.utils.solr.schemamanager.schema.Field
import org.twitterist.utils.solr.schemamanager.dsl._

class DSLSpec extends WordSpec with MustMatchers {

  "Field DSL" must {
    "support static field construction" in {
      val f = field("foo").get()
      f shouldBe a[Field]
      f shouldBe a[Field]
      f.name shouldEqual "foo"
      f.dynamic shouldEqual false
    }

    "support dynamic field construction" in {
      val f = dynamicField("foo").get()
      f shouldBe a[Field]
      f.name shouldEqual "foo"
      f.dynamic shouldEqual true
    }

    "support field type" in {
      val f = (field("foo") withType "boolean").get()
      f shouldBe a[Field]
      f.fieldType shouldEqual "boolean"
    }

    "support default value" in {
      val f = (field("foo") default "default value" is indexed isNot stored).get()
      f shouldBe a[Field]
      f.defaultValue shouldEqual "default value"
    }

    "support options" in {
      val f = (field("foo") is indexed isNot stored).get()
      f shouldBe a[Field]
      f.indexed shouldEqual Some(true)
      f.stored shouldEqual Some(false)
      f.required shouldEqual None
    }
  }
}