package com.michaelszymczak.blogsupport.coati.support.parsing;


import java.util.List;

public interface ExtractedData {

  static ExtractedData data(SplittingPattern pattern, String input) {
    return new SimpleExtractedData(pattern, input);
  }

  static ExtractedData data(SplittingPattern outerSplittingPattern, SplittingPattern innerPattern, String input) {
    return new ComplexExtractedData(outerSplittingPattern, innerPattern, input);
  }

  List<?> extracted();
}