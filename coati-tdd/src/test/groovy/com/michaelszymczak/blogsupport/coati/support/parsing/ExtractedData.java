package com.michaelszymczak.blogsupport.coati.support.parsing;


import java.util.List;

public interface ExtractedData {

  static ExtractedData data(String pattern, String input) {
    return new SimpleExtractedData(pattern, input);
  }

  static ExtractedData data(String outerPattern, String innerPattern, String input) {
    return new ComplexExtractedData(outerPattern, innerPattern, input);
  }

  List<?> extracted();
}