package com.michaelszymczak.diamond.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Letter {
  A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

  public List<Letter> inclusiveSequence() {
    return Stream.of(values())
            .filter(l -> l.ordinal() <= ordinal())
            .sorted((l1, l2) -> Integer.compare(l1.ordinal(), l2.ordinal()))
            .collect(Collectors.toList());
  }
}
