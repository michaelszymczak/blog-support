package com.michaelszymczak.blogsupport.coati.support.parsing

import spock.lang.Specification

class ExtractedDataShould extends Specification {
  def "extract data using provided pattern"() {
    given:
    expect: ExtractedData.simpleData("(.+) sold (.+) per share", "FOO sold USD 15.00 per share").extracted() == [
            "FOO", "USD 15.00"
    ]
  }

  def "extract nested data using provided pattern and another extractor"() {
    given:
    def outerData = ExtractedData.simpleData("(.+) and (.+)", "FOO sold USD 15.00 per share and BAR sold USD 30.00 per share")
    def data = ExtractedData.nestedData("(.+) sold (.+) per share", outerData)

    expect: data.extracted() == [
            ["FOO", "USD 15.00"],
            ["BAR", "USD 30.00"]
    ]
  }
}
