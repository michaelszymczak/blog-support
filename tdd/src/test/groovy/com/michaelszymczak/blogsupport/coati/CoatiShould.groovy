package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class CoatiShould extends Specification
{
  def "exist"() {
    expect: new Coati() != null
  }
}
