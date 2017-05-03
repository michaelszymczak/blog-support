package com.michaelszymczak.diamond

import spock.lang.Specification

class AppTest extends Specification {
    def "application prints diamond"() {
        setup:
        def app = new App()

        when:
        def result = app.greeting

        then:
        result.contains("G")
    }
}
