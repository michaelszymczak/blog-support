package com.michaelszymczak.blogsupport

import spock.lang.Specification

class TddTest extends Specification {
    def "application has a greeting"() {
        setup:
        def app = new Tdd()

        when:
        def result = app.greeting

        then:
        result != null
    }
}
