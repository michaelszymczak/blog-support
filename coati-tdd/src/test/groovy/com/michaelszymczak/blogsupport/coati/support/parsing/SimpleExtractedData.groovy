package com.michaelszymczak.blogsupport.coati.support.parsing

import static com.google.common.base.Preconditions.checkNotNull

class SimpleExtractedData implements ExtractedData {

  private final SplittingPattern pattern
  private final String input

  def SimpleExtractedData(SplittingPattern pattern, String input) {
    this.pattern = checkNotNull(pattern)
    this.input = checkNotNull(input)
  }

  List<?> extracted() {
    if (input.trim().isEmpty())
    {
      return []
    }

    def matcher = (input =~ pattern.pattern())
    assert matcher.matches()

    (1..matcher.groupCount())
            .collect { int position -> matcher.group(position) }
  }
}