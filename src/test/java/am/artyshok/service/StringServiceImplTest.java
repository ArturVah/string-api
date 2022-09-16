package am.artyshok.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StringServiceImplTest {

  @InjectMocks
  private StringServiceImpl stringService;

  @Test
  void givenString_whenCalled_thenOk() {
    //Test data
    final var initStr = "example";
    final var result = "elpmaxe";
    //Run test scenario
    final String reverse = stringService.reverse(initStr);
    //assert
    assertThat(reverse).isEqualTo(result);

  }

  @Test
  void givenNull_whenCalled_thenError() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      stringService.reverse(null);
    });
  }
}
