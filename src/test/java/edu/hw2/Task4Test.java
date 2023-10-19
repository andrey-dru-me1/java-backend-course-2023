package edu.hw2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import edu.hw2.task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task4Test {
  @Test
  @DisplayName("Удалённый сервер")
  void test() {
    CallingInfo callingInfo = CallingInfo.callingInfo();
    assertThat(callingInfo.className()).isEqualTo(CallingInfo.class.getName());
    assertThat(callingInfo.methodName()).isEqualTo("callingInfo");
  }
}
