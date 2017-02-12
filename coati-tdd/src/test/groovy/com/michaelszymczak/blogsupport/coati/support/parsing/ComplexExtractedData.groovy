package com.michaelszymczak.blogsupport.coati.support.parsing

class ComplexExtractedData  implements ExtractedData {

  private final String pattern
  private final ExtractedData data

  ComplexExtractedData(String pattern, ExtractedData data) {

  }

  @Override
  List extracted() {
    [
            ["FOO", "USD 15.00"],
            ["BAR", "USD 30.00"]
    ]
  }
}