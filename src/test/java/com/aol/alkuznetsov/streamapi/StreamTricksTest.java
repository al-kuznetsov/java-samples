package com.aol.alkuznetsov.streamapi;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

class StreamTricksTest {

  @Test
  void reduceListToSingleValueTestOk() {

    List<Container> list = new ArrayList<>(5);
    list.add(new Container(1, "One"));
    list.add(new Container(2, "Two"));
    list.add(new Container(3, "Three"));
    list.add(new Container(4, "Four"));
    list.add(new Container(5, "Five"));

    int targetId = 4; // There is only one in the list
    String singleValue = StreamTricks.reduceListToSingleValue(list, targetId);

    Assertions.assertThat(singleValue).isEqualTo("Four");
  }

  @Test
  void reduceListToSingleValueTestNull() {

    List<Container> list = new ArrayList<>(5);
    list.add(new Container(1, "One"));
    list.add(new Container(2, "Two"));
    list.add(new Container(3, "Three"));
    list.add(new Container(4, "Four"));
    list.add(new Container(5, "Five"));

    int targetId = 66; // There is only one in the list
    String singleValue = StreamTricks.reduceListToSingleValue(list, targetId);

    Assertions.assertThat(singleValue).isNull();
  }

  @Test
  void reduceListToSingleValueTestError() {

    List<Container> list = new ArrayList<>(5);
    list.add(new Container(1, "One"));
    list.add(new Container(2, "Two"));
    list.add(new Container(4, "Three"));
    list.add(new Container(4, "Four")); // duplicated!
    list.add(new Container(5, "Five"));

    int targetId = 4; // There is only one in the list
    ThrowingCallable call = () -> StreamTricks.reduceListToSingleValue(list, targetId);

    Assertions.assertThatThrownBy(call)
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("4");
  }
}
