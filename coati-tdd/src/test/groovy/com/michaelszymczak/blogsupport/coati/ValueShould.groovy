package com.michaelszymczak.blogsupport.coati

import spock.lang.Specification

class ValueShould extends Specification {

  def "be comparable by its state"() {
    given:
    final Value foo = new Something("foo")

    expect:
    ! foo.is(new Something("foo"))
    foo == new Something("foo")
    foo != new Something("bar")
  }

  def "have a default way of displaying its state"() {
    expect:
    new Something("foo").toString() == "foo"
  }

  private class Something extends Value
  {
    private final String data;

    Something(String data) {
      this.data = data
    }
  }
}
