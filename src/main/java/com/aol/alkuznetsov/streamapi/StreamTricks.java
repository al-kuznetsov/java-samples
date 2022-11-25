package com.aol.alkuznetsov.streamapi;

import java.util.List;

public class StreamTricks {

  /**
   * If we know there must be a single value, we can reduce a list to a single value and throw error
   * if there are more resulting values.
   *
   * @return true if the method finished
   */
  public static String reduceListToSingleValue(List<Container> list, int targetId) {

    return list.stream()
        .filter(x -> x.id().equals(targetId))
        .map(Container::name)
        .reduce(
            (a, b) -> {
              throw new IllegalStateException("Multiple items found with id: " + targetId);
            })
        .orElse(null);
  }

}

record Container(Integer id, String name) {}
