package com.michaelszymczak.blogsupport.coati.support

class ExtractedData {

  private final String pattern
  private final String input

  ExtractedData(String pattern, String input) {
    this.pattern = pattern
    this.input = input
  }

  List extracted() {
    def matcher = (input =~ pattern)
    assert matcher.matches()

    (1..matcher.groupCount()).collect { int position -> matcher.group(position) }
  }
}