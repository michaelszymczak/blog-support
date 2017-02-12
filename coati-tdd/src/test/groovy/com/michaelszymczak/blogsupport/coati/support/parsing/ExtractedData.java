package com.michaelszymczak.blogsupport.coati.support.parsing;


import java.util.List;

public interface ExtractedData {

  static ExtractedData simpleData(String pattern, String input) {
    return new SimpleExtractedData(pattern, input);
  }

  static ExtractedData nestedData(String pattern, ExtractedData data) {
    return new ComplexExtractedData(pattern, data);
  }

  List<?> extracted();
}