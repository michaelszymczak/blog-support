package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class CoatiShould extends Specification {
  def "be executable"() {
    expect:
    Coati.main()
  }
}
