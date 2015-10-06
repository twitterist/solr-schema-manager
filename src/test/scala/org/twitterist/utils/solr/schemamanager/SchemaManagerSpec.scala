package org.twitterist.utils.solr.schemamanager

import org.scalatest.{MustMatchers, WordSpec}
import org.scalatest.Matchers._

class SchemaManagerSpec extends WordSpec with MustMatchers {

  "instance" must {
    "implement SchemaOperations" in {
      SchemaManager() shouldBe a [SchemaOperations]
    }
    "support Settings" in {
      SchemaManager() shouldBe a [Settings]
    }
  }
}