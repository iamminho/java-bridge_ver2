package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Moving 클래스는")
class MovingTest {
    @Nested
    @DisplayName("Moving 생성자는")
    class Describe_Moving_constructor {

        @Nested
        @DisplayName("만약 매개변수가 U나 D가 아니라면")
        class Context_parameter_is_not_U_or_D {

            @ValueSource(strings = {"1", "T", " ", " U", "D ", "Ua", "U@", "UD"})
            @ParameterizedTest
            @DisplayName("애러를 발생시킨다.")
            void it_returns_illegal_argument_exception_error(String input) {
                assertThatThrownBy(() -> new Moving(input))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
