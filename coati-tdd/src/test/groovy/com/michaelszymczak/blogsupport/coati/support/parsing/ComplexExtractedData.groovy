package com.michaelszymczak.blogsupport.coati.support.parsing

import static com.google.common.base.Preconditions.checkNotNull

class ComplexExtractedData  implements ExtractedData {

  private final String pattern
  private final ExtractedData data

  ComplexExtractedData(String pattern, ExtractedData data) {
    this.pattern = checkNotNull(pattern)
    this.data = checkNotNull(data)
  }

  @Override
  List<?> extracted() {
    data.extracted()
            .collect { simpleData(pattern, it as String) }
            .collect { it.extracted() }
  }
}