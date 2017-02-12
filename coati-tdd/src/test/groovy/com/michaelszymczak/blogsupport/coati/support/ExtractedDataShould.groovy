package com.michaelszymczak.blogsupport.coati.support

import spock.lang.Specification

class ExtractedDataShould extends Specification {
  def "should extract data using provided pattern"() {
    given:
    expect: new ExtractedData("(.+) sold (.+) per share", "FOO sold USD 15.00 per share").extracted() == [
            "FOO", "USD 15.00"
    ]
  }
}
