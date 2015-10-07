package org.twitterist.utils.solr.schemamanager.client

import org.scalatest.MustMatchers
import org.scalatest.WordSpec
import org.scalatest.{MustMatchers, WordSpec}
import org.scalatest.Matchers._
import org.twitterist.utils.solr.schemamanager.SchemaManager
import org.twitterist.utils.solr.schemamanager.SchemaOperations
import org.twitterist.utils.solr.schemamanager.Settings

class DispatchHttpClientSpec extends WordSpec with MustMatchers {
  "Instance" must {
    "implement HttpClient" in {
      DispatchHttpClient() shouldBe a[HttpClient]
    }
  }
}
