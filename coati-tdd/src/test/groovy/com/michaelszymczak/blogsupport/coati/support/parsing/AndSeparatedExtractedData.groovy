package com.michaelszymczak.blogsupport.coati.support.parsing

class AndSeparatedExtractedData implements ExtractedData {

  private final ExtractedData data

  AndSeparatedExtractedData(SplittingPattern pattern, String input) {
    this.data = new ComplexExtractedData(new SplittingPattern.And(input), pattern, input)
  }

  @Override
  List<?> extracted() {
    data.extracted()
  }
}