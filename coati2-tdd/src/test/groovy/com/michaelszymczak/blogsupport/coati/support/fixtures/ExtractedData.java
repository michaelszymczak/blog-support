package com.michaelszymczak.blogsupport.coati.support.fixtures;

import java.util.List;

public interface ExtractedData {

  static ExtractedData data(SplittingPattern pattern, String input) {
    return new AndSeparatedExtractedData(pattern, input);
  }

  List<?> extracted();
}