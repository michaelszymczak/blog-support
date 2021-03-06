package com.michaelszymczak.blogsupport.coati.support.fixtures

import static com.google.common.base.Preconditions.checkNotNull

class ComplexExtractedData  implements ExtractedData {

  private final SplittingPattern pattern
  private final ExtractedData data

  ComplexExtractedData(SplittingPattern outerPattern, SplittingPattern innerPattern, String input) {
    this( innerPattern, new SimpleExtractedData(outerPattern, input))
  }

  ComplexExtractedData(SplittingPattern pattern, ExtractedData data) {
    this.pattern = checkNotNull(pattern)
    this.data = checkNotNull(data)
  }

  @Override
  List<?> extracted() {
    data.extracted()
            .collect { new SimpleExtractedData({ pattern.pattern() }, it as String) }
            .collect { it.extracted() }
  }
}