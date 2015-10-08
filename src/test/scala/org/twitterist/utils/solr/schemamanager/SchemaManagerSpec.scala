package org.twitterist.utils.solr.schemamanager

import org.scalatest.{ MustMatchers, WordSpec }
import org.scalatest.Matchers._

class SchemaManagerSpec extends WordSpec with MustMatchers {

  "Instance" must {
    "implement SchemaOperations" in {
      SchemaManager() shouldBe a[SchemaOperations]
    }
    "support Settings" in {
      SchemaManager() shouldBe a[Settings]
      SchemaManager(url = "http://foo.bar") shouldBe a[Settings]
      SchemaManager(url = "http://foo.bar", allowOverride = true) shouldBe a[Settings]
    }
  }
}