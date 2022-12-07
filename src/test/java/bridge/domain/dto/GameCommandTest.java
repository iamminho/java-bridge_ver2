package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("GameCommand 클래스는")
class GameCommandTest {
    @Nested
    @DisplayName("GameCommand 생성자는")
    class Describe_GameCommand_constructor {

        @Nested
        @DisplayName("만약 매개변수가 R이나 Q가 아니라면")
        class Context_parameter_is_not_R_or_Q {

            @ValueSource(strings = {"t", "53", " Q", "R ", " ", "R@", "&"})
            @ParameterizedTest
            @DisplayName("애러를 발생시킨다.")
            void it_returns_illegal_argument_exception_error(String input) {
                assertThatThrownBy(() -> new GameCommand(input))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
