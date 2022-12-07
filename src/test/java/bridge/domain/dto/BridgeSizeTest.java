package bridge.domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("BridgeSize 클래스")
class BridgeSizeTest {

    @Nested
    @DisplayName("BridgeSize 생성자는")
    class Describe_BridgeSize_constructor {

        @Nested
        @DisplayName("입력된 다리길이가 3에서 20사이의 숫자가 아니라면")
        class Context_bridge_size_not_between_3_to_20 {

            @ValueSource(ints = {0, 21, 132, 279})
            @ParameterizedTest
            @DisplayName("에러를 발생시킨다.")
            void it_returns_illegal_argument_error(int size) {
                assertThatThrownBy(() -> new BridgeSize(size))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
