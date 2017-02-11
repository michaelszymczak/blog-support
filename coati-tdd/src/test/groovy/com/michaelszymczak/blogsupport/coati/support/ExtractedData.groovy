package com.michaelszymczak.blogsupport.coati.support

class ExtractedData {
  private final String pattern
  private final String input
  private final int placeholders

  ExtractedData(String pattern, String input, int placeholders) {
    this.pattern = pattern
    this.input = input
    this.placeholders = placeholders
  }

  List extracted() {
    def data = (input =~ pattern)[0] as List
    assert data.size() == placeholders + fullMatchComponent()

    data
  }

  private static int fullMatchComponent() {
    1
  }
}