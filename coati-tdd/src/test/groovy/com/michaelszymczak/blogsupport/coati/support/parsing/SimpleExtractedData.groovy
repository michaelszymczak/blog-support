package com.michaelszymczak.blogsupport.coati.support.parsing

import static com.google.common.base.Preconditions.checkNotNull

class SimpleExtractedData implements ExtractedData {

  private final String pattern
  private final String input

  def SimpleExtractedData(String pattern, String input) {
    this.pattern = checkNotNull(pattern)
    this.input = checkNotNull(input)
  }

  List extracted() {
    def matcher = (input =~ pattern)
    assert matcher.matches()

    (1..matcher.groupCount())
            .collect { int position -> matcher.group(position) }
  }
}